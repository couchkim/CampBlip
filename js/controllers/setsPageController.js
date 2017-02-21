module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {

// These are the filters for the search
        $scope.levels = [];
        $scope.available = [];
        $scope.themes = [];

// These are the inputs and dropdown selections from the search
        $scope.byName = '';
        $scope.byNumber = '';
        $scope.byTheme = '';
        $scope.byLevel = '';
        $scope.byStatus = '';
        $scope.filters = '';

// Gets filters from database and populates empty arrays above
        CampService.getFilters().then(function (response) {
            $scope.levels = response.skills;
            $scope.available = response.status;
            $scope.themes = response.themes;

            console.log(response);
        });


// Gets all sets when the Show All Sets button is clicked
        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };

// Gets sets after Search for Sets button is clicked based on the filters selected
        $scope.viewSearchSets = function () {
            $scope.sets = CampService.getSearchSets($scope.byName, $scope.byNumber,
                $scope.byTheme, $scope.byLevel, $scope.byStatus);
            
            console.log($scope.sets);
        };


    },
}