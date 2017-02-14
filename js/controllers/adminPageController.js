module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';
        $scope.newCamper = '';
        $scope.weeks = '';

        $scope.newSet = function () {
            let newInfo = CampService.addSet($scope.setNumber);
            // console.log(newInfo);
        }

        $scope.removeSet = function(){
                       
            CampService.deleteSet($scope.setId);
        }

        $scope.addCamper = function(){
            CampService.newCamper($scope.newCamper, $scope.weeks);
        }


       

        // console.log('admin page controller working');


    },
}