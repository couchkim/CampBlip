module.exports = {

    name: "CampService",
    func: function ($http) {


        function Set(name, number, theme, pieces, status, image, year) {
            this.setName = name;
            this.setNumber = number;
            this.theme = theme;
            this.pieces = pieces;
            this.status = status;
            this.image = image;
            this.year = year;


            return this;
        }


        let sets = [];

        sets.push(new Set('Space Moon Buggy', '3365-1', 'City', 37, 'Available', 'http://images.brickset.com/sets/images/3365-1.jpg?201012090229', 2005));
        sets.push(new Set('The First Night', '21115-1', 'Minecraft', 408, 'Checked Out', 'http://images.brickset.com/sets/large/21115-1.jpg?201410080618', 2014));
        sets.push(new Set('The Batcave', '6860-1', 'Super Heroes', 690, 'Missing Pieces', 'http://images.brickset.com/sets/images/6860-1.jpg?201110150701', 2013));
        sets.push(new Set('Death Star', '10188-1', 'Star Wars', 3803, 'On Display', 'http://images.brickset.com/sets/AdditionalImages/10188-1/10188-0000-xx-13-1.jpg', 2015));
        sets.push(new Set('Yellow Submarine', '21306-1', 'Ideas', 553, 'Checked Out', 'http://images.brickset.com/sets/images/21306-1.jpg?201610150938', 2017));

        console.log(sets);

        return {

            getSets() {

                $http.get("https://camp-blip-legos.herokuapp.com/").then(function (response) {
                    console.log(response);

                });

                return sets;
            },

            getSet(id){

                for (let i = 0; i < sets.length; i++){
                    if (sets[i].setNumber === id){
                        return sets [i];
                    }
                }
            },

        }
    },
};

