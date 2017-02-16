module.exports = {

    name: "instructionsPageController",
    func: function ($scope, $sce, $http, CampService, $stateParams) {

        const partSet = ($stateParams.single);
        console.log("parts");

        $scope.partSet = CampService.getSet(partSet);
        console.log($scope.partSet);

        $scope.instructions = $sce.trustAsResourceUrl($scope.partSet.instructions);
        $http.get($scope.instructions, { responseType: 'arraybuffer' })
            .then(function (response) {
                const pdf = new Blob([response.data], {
                    type: 'application/pdf',
                });

                const url = URL.createObjectURL(pdf);
                $scope.knowledge = $sce.trustAsResourceUrl(url);
                console.log(url);
            });
        console.log($scope.instructions);



    },
}