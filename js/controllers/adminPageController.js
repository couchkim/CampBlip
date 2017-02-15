module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';
        $scope.newCamper = '';
        $scope.weeks = '';
        $scope.newInfo = null;
        

        $scope.newSet = function () {
            $scope.newInfo = CampService.addSet($scope.setNumber);
            console.log($scope.newInfo);
            $scope.setNumber = '';
           
        }

        $scope.removeSet = function(){
                       
            CampService.deleteSet($scope.setId);
        }

        $scope.addCamper = function(){
            CampService.newCamper($scope.newCamper, $scope.weeks);
        }

    },
}