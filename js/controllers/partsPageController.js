module.exports = {

    name: "partsPageController",
    func: function ($scope, CampService, $stateParams) {

        const partSet = ($stateParams.single);
        console.log("parts");
        $scope.partSet = CampService.getSet(partSet);
        console.log($scope.partSet);

        $scope.parts = $scope.partSet.parts;
        console.log($scope.parts);

        $scope.partQty = '';
       


        $scope.changeQty = function (set, part) {
            part.currInv = part.setQty;
            CampService.updateQty(set, part.setPartId, part.currInv);
            console.log(set, part.setPartId, part.currInv);

        };

        $scope.sendQty = function (set, part) {
            CampService.updateQty(set, part.setPartId, part.currInv);
            console.log(set, part.setPartId, part.currInv);

        };

        $scope.finalQty = function (set) {
            CampService.submitInv(set);


        };

        $scope.checkAll = function () {
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            angular.forEach($scope.parts, function (part) {
                part.Selected = $scope.selectedAll;
                $scope.changeQty(part.setId, part);
            });

        };



    },
}

