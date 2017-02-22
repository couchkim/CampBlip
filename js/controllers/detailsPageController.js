module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {


        // $scope.campers = ['Wilson Rhee', 'Carter Bateman', 'Collier McElroy',
        //     'Alexander Paschal', 'Holden Harrell'];

        // $scope.camperList = '';
        $scope.newNote = '';
        $scope.byStatus = '';
        $scope.statusList = [];
        // $scope.item.displayStatus = '';


        const id = parseInt($stateParams.single);

        // Getting specific set so that details for just that set are displayed
        CampService.getSet(id).then(function (response) {
            $scope.item = response;
            console.log($scope.item);
        });


        // When click Check In or Check Out button it toggles the button and changes the status
        $scope.checkToggle = function () {
            $scope.item.status = CampService.changeStatus($scope.item.setId, $scope.item.status);
            // if ($scope.item.status === "CHECKED_OUT") {
            //     $scope.item.displayStatus = "Checked Out"
            // } else
            //     if ($scope.item.status === "MISSING_PIECES") {
            //         $scope.item.displayStatus = "Missing Pieces";
            //     } else
            //         if ($scope.item.status === "ON_DISPLAY") {
            //             $scope.item.displayStatus = "On Display";
            //         } else {
            //             $scope.item.displayStatus = "Available";

            //         }
        }


        // Getting list of status options from database
        CampService.getFilters().then(function (response) {
            $scope.statusList = response.status;
            console.log(response);
        });

        // Updating database with admin notes or admin change to status
        $scope.updateSet = function (item) {
            CampService.sendUpdate(item.setId, $scope.byStatus, $scope.newNote);
        }

    },
}



