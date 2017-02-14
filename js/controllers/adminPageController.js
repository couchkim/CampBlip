module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';

        $scope.newSet = function () {
            CampService.addSet($scope.setNumber);
        }

        $scope.removeSet = function(){
                       
            CampService.deleteSet($scope.setId);
        }


       

        // console.log('admin page controller working');


    },
}