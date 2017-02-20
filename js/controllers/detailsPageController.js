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


        const id = parseInt($stateParams.single);

       CampService.getSet(id).then(function(response){
            $scope.item = response;
            console.log($scope.item);

        });
        


        $scope.getParts = function (item) {
            console.log(item);
            console.log(CampService.showParts(item));
        }

        $scope.checkToggle = function () {
            $scope.item.status = CampService.changeStatus($scope.item.setId, $scope.item.status);
            // if($scope.item.status === "CHECKED_OUT"){
            //     $scope.item.statusDisplay = "Checked Out"
            // in get set function, not here
            // }
        }

         CampService.getFilters().then(function (response) {  
            $scope.available = response.status;
            console.log(response);
        });

        $scope.updateSet = function (item){
            CampService.sendUpdate(item.setId, $scope.byStatus, $scope.newNote);
        }

    },
}



