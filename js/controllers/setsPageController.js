module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {


// all of these arrays will be populated from the initial page load JSON response

    //    $scope.levels = [];
    //    $scope.available = [];
    //    $scope.themes = [];

        $scope.levels = ['Beginner', 'Intermediate', 'Advanced', 'Expert'];

        $scope.available = ['Available', 'Checked Out', 'Missing Pieces', 'On Display'];

        $scope.themes = ['Advanced Models', 'Agents', 'Alien Conquest', 'Aqua Raiders', 'Architecture', 'Atlantis', 'Batman', 'Bionicle', 'Cars2', 'Castle',
            'Chima', 'City', 'Creator', 'Dino', 'LEGO Friends', 'Galaxy Squad', 'Ghostbusters', 'Harry Potter', 'Hero Factory', 'Hobbit', 'Ideas', 'Indiana Jones', 'Lego Movie',
            'Lone Ranger', 'Lord of the Rings', 'Mars Mission', 'Minecraft', 'Monster Fighters', 'Ninjago', 'Power Miners', 'Prince of Persia', 'Racers', 'Scooby-Doo', 'Space Police',
            'Speed Champions', 'Spongebob', 'Sports', 'Star Wars TM', 'Super Heroes', 'Technic', 'Teenage Mutant Ninja Turtles',
            'The Simpsons', 'Toy Story', 'Ultra Agents', 'Vintage', 'Wall-E'];

        $scope.byName = '';
        $scope.byNumber = '';
        $scope.byTheme = '';
        $scope.byLevel = '';
        $scope.byStatus = '';

        // const filters = CampService.getFilters();
            
        //     $scope.levels = filters.skills;
        //     $scope.available = filters.status;
        //     $scope.themes = filters.themes;
        // }

        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };

         $scope.viewSearchSets = function () {
            // $scope.sets = CampService.getSearchSets($scope.byName, $scope.byNumber,
            // $scope.byTheme, $scope.byLevel, $scope.byStatus);
            $scope.sets = CampService.getSearchSets($scope.byTheme);
            console.log($scope.sets);
        };





        // console.log('sets page controller working');



    },
}