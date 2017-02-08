module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {

       const id = ($stateParams.single);
       console.log("hello");
       $scope.item = CampService.getSet(id);
       console.log($scope.item);

            console.log('detail page controller working');
        

    },
}



