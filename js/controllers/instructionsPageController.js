module.exports = {

    name: "instructionsPageController",
    func: function ($scope, CampService, $stateParams) {

        const partSet = ($stateParams.single);
        console.log("parts");

        $scope.partSet = CampService.getSet(partSet);
        console.log($scope.partSet);

        $scope.instructions = $scope.partSet.instructions;
        console.log($scope.instructions);



    },
}