module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {

        $scope.pieces = ['Fewer than 200', '200-500', '500-1000', 'More than 1000'];

        $scope.available = ['Available', 'Checked Out', 'Missing Pieces', 'On Display'];

        $scope.themes = ['Advanced Models', 'Agents', 'Alien Conquest', 'Aqua Raiders', 'Architecture', 'Atlantis', 'Batman', 'Bionicle', 'Cars2', 'Castle',
            'Chima', 'City', 'Creator', 'Dino', 'Friends', 'Galaxy Squad', 'Ghostbusters', 'Harry Potter', 'Hero Factory', 'Hobbit', 'Indiana Jones', 'Lego Movie',
            'Lone Ranger', 'Lord of the Rings', 'Mars Mission', 'Minecraft', 'Monster Fighters', 'Ninjago', 'Power Miners', 'Prince of Persia', 'Racers', 'Scooby Doo', 'Space Police',
            'Speed Champions', 'Spongebob', 'Sports', 'Star Wars', 'Super Heroes', 'Technic', 'Teenage Mutant Ninja Turtles',
            'The Simpsons', 'Toy Story', 'Ultra Agents', 'Vintage', 'Wall-E'];

        $scope.viewSets = function () {
            CampService.getSets();
            console.log(sets);
        };



        console.log('sets page controller working');



    },
}