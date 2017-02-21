module.exports = {

    name: "accountPageController",
    func: function ($scope, $http, CampService) {


  const self = this

  const authenticate = function(credentials, callback) {

    const headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).then(function(response) {
      if (response.data.name) {
        $scope.authenticated = true;
      } else {
        $scope.authenticated = false;
      }
      callback && callback();
    }, function() {
      $scope.authenticated = false;
      callback && callback();
    });

  }

  authenticate();
  self.credentials = {};
  self.login = function() {
      authenticate(self.credentials, function() {
        if ($scope.authenticated) {
          $location.path("/");
          self.error = false;
        } else {
          $location.path("/login");
          self.error = true;
        }
      });
  };
            
        

    },
}