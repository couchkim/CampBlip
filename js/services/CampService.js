module.exports = {

    name: "CampService",
    func: function ($http) {


        function Set(name, number, theme, pieces, status, image, year, skill, invDate, invName,
            invNeed, invParts, checkout, instructions, notes) {
            this.setName = name;
            this.setNumber = number;
            this.theme = theme;
            this.pieces = pieces;
            this.status = status;
            this.image = image;
            this.year = year;
            this.skill = skill;
            // array with beginner, etc.
            this.invDate = invDate;
            // last inventoried date
            this.invName = invName;
            // who inventoried it
            this.invNeed = invNeed;
            // Boolean t or f for needs inventory
            this.lastCheckout = checkout;
            // last date that set was checked out
            this.invParts = invParts;
            // how many parts we had after inventory
            this.missing = 0;
            // number of pieces missing from the set
            this.order = 'lots of pieces';
            // text string from admin input
            this.notes = notes;
            // text string from admin input
            this.parts = [
                {
                    name: 'antennae',
                    color: 'black',
                    id: '123456',
                    photo: 'https://i.stack.imgur.com/xCxdq.jpg',
                    setQuantity: 3,
                    invQuantity: 3,
                },
                {
                    name: 'antennae longer name',
                    color: 'black',
                    id: '123456',
                    photo: 'https://i.stack.imgur.com/xCxdq.jpg',
                    setQuantity: 3,
                    invQuantity: 3,
                },
                {
                    name: 'antennae',
                    color: 'black',
                    id: '123456',
                    photo: 'https://i.stack.imgur.com/xCxdq.jpg',
                    setQuantity: 3,
                    invQuantity: 3,
                }
            ];
            // array of all parts in the set that comes when parts button is clicked
            this.instructions = instructions;


            return this;
        };


        let sets = [];

        // sets.push(new Set('Space Moon Buggy', '3365-1', 'City', 37, 'Available', 'http://images.brickset.com/sets/images/3365-1.jpg?201012090229', 2005));
        // sets.push(new Set('The First Night', '21115-1', 'Minecraft', 408, 'Checked Out', 'http://images.brickset.com/sets/large/21115-1.jpg?201410080618', 2014));
        // sets.push(new Set('The Batcave', '6860-1', 'Super Heroes', 690, 'Missing Pieces', 'http://images.brickset.com/sets/images/6860-1.jpg?201110150701', 2013));
        // sets.push(new Set('Death Star', '10188-1', 'Star Wars', 3803, 'On Display', 'http://images.brickset.com/sets/AdditionalImages/10188-1/10188-0000-xx-13-1.jpg', 2015));
        // sets.push(new Set('Yellow Submarine', '21306-1', 'Ideas', 553, 'Checked Out', 'http://images.brickset.com/sets/images/21306-1.jpg?201610150938', 2017));

        console.log(sets);

        return {

            getSets() {

                $http.get("/sets").then(function (response) {
                    // $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);


                    for (let i = 0; i < response.data.sets.length; i++) {
                        let item = response.data.sets;
                        item[i] = new Set(item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_need, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                    }
                    angular.copy(response.data.sets, sets);


                });

                return sets;
            },

            getSet(id) {

                for (let i = 0; i < sets.length; i++) {
                    if (sets[i].setNumber === id) {
                        return sets[i];
                    }
                }
            },

            addSet(num) {

                $http.post("/add-set/" + num).then(function (response) {
                    // $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);
                })

            },
        }
    },
};

