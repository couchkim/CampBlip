module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {


        $scope.campers = ['Wilson Rhee', 'Carter Bateman', 'Collier McElroy',
            'Alexander Paschal', 'Holden Harrell'];

        $scope.camperList = '';
        $scope.newNote = '';
        $scope.byStatus = '';
        $scope.available = [];
        // $scope.item.statusDisplay = '';
        
        // $scope.item.statusDisplay = $scope.item.status;


        const id = ($stateParams.single);

        $scope.item = CampService.getSet(id);
        console.log($scope.item);


        $scope.getParts = function (item) {
            CampService.showParts(item);
            console.log(CampService.showParts(item));
        }

        $scope.checkToggle = function () {
            $scope.item.status = CampService.changeStatus($scope.item.setId, $scope.item.status);
            // if($scope.item.status === "CHECKED_OUT"){
            //     $scope.item.statusDisplay = "Checked Out"
            // }
        }

         CampService.getFilters().then(function (response) {  
            $scope.available = response.status;
            console.log(response);
        });

        $scope.updateSet = function (set){
            CampService.sendUpdate(set, $scope.byStatus, $scope.newNote);
        }



    },
}



