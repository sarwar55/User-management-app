angular.module('app.controllers', []).controller('UserController', function($scope, $state, popupService, $window, User) {
  $scope.users = User.query(); //fetch all users. Issues a GET to /api/vi/users

  $scope.deleteUser = function(user) { // Delete a User. Issues a DELETE to /api/v1/user/:id
    if (popupService.showPopup('Really delete this?')) {
      user.$delete(function() {
        $scope.users = User.query(); 
        $state.go('users');
      });
    }
  };
}).controller('UserViewController', function($scope, $stateParams, User) {
  $scope.user = User.get({ id: $stateParams.id }); //Get a single User.Issues a GET to /api/v1/user/:id
}).controller('UserCreateController', function($scope, $state, $stateParams, User) {
  $scope.user = new User();  //create new user instance. Properties will be set via ng-model on UI

  $scope.user = function() { //create a new users. Issues a POST to /api/v1/users
    $scope.user.$save(function() {
      $state.go('users'); // on success go back to the list i.e. users state.
    });
  };
}).controller('UserEditController', function($scope, $state, $stateParams, User) {
  $scope.updateUser = function() { //Update the edited user. Issues a PUT to /api/v1/users/:id
    $scope.shipwreck.$update(function() {
      $state.go('users'); // on success go back to the list i.e. users state.
    });
  };

  $scope.loadUser = function() { //Issues a GET request to /api/v1/users/:id to get a shipwreck to update
    $scope.user = User.get({ id: $stateParams.id });
  };

  $scope.loadUser(); // Load a user which can be edited on UI
});
