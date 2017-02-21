module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';
        $scope.newCamper = '';
        $scope.weeks = '';
        $scope.newInfo = null;
        $scope.partySet = '';
        $scope.partySets = null;
        $scope.allPartySetInfo = null;
        $scope.parseInt = parseInt;
        $scope.partyChild = '';


        $scope.newSet = function () {
            CampService.addSet($scope.setNumber).then(function (response) {
                $scope.newInfo = response;
                console.log(response);
            });

            console.log($scope.newInfo);
            $scope.setNumber = '';

        };

        $scope.removeSet = function () {

            CampService.deleteSet($scope.setId);
        };

        $scope.addCamper = function () {
            CampService.newCamper($scope.newCamper, $scope.weeks);
        };

        $scope.newPartySet = function (set) {
            $scope.partySets = CampService.addPartySet(set);
            $scope.partySet = '';

        };

        $scope.createPartyCatalog = function () {
            CampService.getPartyInfo($scope.partySets).then(function (response) {
                $scope.allPartySetInfo = response;
                console.log($scope.allPartySetInfo);
            })


        }


    },
}