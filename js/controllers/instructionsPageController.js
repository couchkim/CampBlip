module.exports = {

    name: "instructionsPageController",
    func: function ($scope, $sce, $http, CampService, $stateParams) {

        const partSet = ($stateParams.single);
       
         CampService.getSet(partSet).then(function (response) {

            $scope.partSet = response;
            $scope.instructions = $scope.partSet.instructions;
         
        });
        
        // $scope.instructions = $scope.partSet.instructions;
        console.log($scope.instructions);
       
    },
}