module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {

       const id = ($stateParams.single);
       
       $scope.item = CampService.getSet(id);
       console.log($scope.item);


       $scope.getParts = function(item){
           CampService.showParts(item);
           console.log(CampService.showParts(item));
       }
            // console.log('detail page controller working');
        

    },
}



