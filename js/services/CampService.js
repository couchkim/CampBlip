module.exports = {

    name: "CampService",
    func: function ($http) {


        function Set(id, name, number, theme, pieces, status, image, year, skill, invDate, invName,
            invNeed, invParts, checkout, instructions, notes) {
            this.setId = id;
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
            this.parts = [];
            
            // array of all parts in the set that comes when parts button is clicked
            this.instructions = instructions;


            return this;
        };


        let sets = [];


        return {

            getSets() {

                $http.get("/sets").then(function (response) {
                    // $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);


                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        item[i] = new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_need, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                    }
                    angular.copy(response.data.setViews, sets);


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
                    console.log(response);
                    let info = response.data;
                    return info;
                    // console.log(response);
                })

            },

            showParts(item) {
                $http.get("/parts/" + item.setId).then(function (response) {
                    angular.copy(response.data.parts, item.parts)
                    console.log(response);
                })
            },

             deleteSet(id) {
                // $http.delete("/parts/" + id).then(function (response) {

                //     console.log(response);
                // })
            },

            newCamper(person, time) {
                // $http.post("/campers/").then(function (response) {

                //     console.log(response);
                // })
            },
        }
    },
};

