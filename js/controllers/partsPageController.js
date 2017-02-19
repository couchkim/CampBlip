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
       $scope.checked = '';

       $scope.changeQty = function(part){
            // $scope.changeQty = function(qty, part){
        //    $scope.partQty = part;
            //   qty = part.setQty;
              part.invQty = part.setQty;
       }
           
           
       
        

    },
}

