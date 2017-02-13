module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';

        $scope.newSet = function () {
            CampService.addSet($scope.setNumber);
        }


        //    $scope.setNumber

        console.log('admin page controller working');


    },
}