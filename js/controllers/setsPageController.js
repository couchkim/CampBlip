module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {



        $scope.levels = [];
        $scope.available = [];
        $scope.themes = [];

    
        $scope.byName = '';
        $scope.byNumber = '';
        $scope.byTheme = '';
        $scope.byLevel = '';
        $scope.byStatus = '';
        $scope.filters = '';


        CampService.getFilters().then(function (response) {
                $scope.levels = response.skills;
                $scope.available = response.status;
                $scope.themes = response.themes;

                console.log(response);
            });
          
       

        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };

        $scope.viewSearchSets = function () {
            $scope.sets = CampService.getSearchSets($scope.byName, $scope.byNumber,
            $scope.byTheme, $scope.byLevel, $scope.byStatus);
            // $scope.sets = CampService.getSearchSets($scope.byTheme, $scope.byStatus, $scope.byLevel);
            console.log($scope.sets);
        };


    },
}