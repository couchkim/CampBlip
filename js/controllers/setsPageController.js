module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {

        $scope.pieces = ['Fewer than 200', '200-500', '500-1000', 'More than 1000'];

        $scope.available = ['Available', 'Checked Out', 'Missing Pieces', 'On Display'];

         console.log('sets page controller working');
            
        

    },
}