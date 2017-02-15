module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {


        $scope.campers = ['Wilson Rhee', 'Carter Bateman', 'Collier McElroy',
            'Alexander Paschal', 'Holden Harrell'];

        $scope.camperList = '';

        const id = ($stateParams.single);

        $scope.item = CampService.getSet(id);
        console.log($scope.item);

    
        $scope.getParts = function (item) {
            CampService.showParts(item);
            console.log(CampService.showParts(item));
        }

        $scope.checkToggle = function () {
            $scope.item.status = CampService.changeStatus($scope.item.status);
        }

    },
}



