module.exports = {

    name: "CampService",
    func: function ($http) {


        function Set(id, name, number, theme, pieces, status, image, year, skill, invDate, invName,
            invStat, invParts, checkout, instructions, notes) {
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
            this.invStat = invStat;
            // three possible states
            this.lastCheckout = checkout;
            // last date that set was checked out
            this.invParts = invParts;
            // how many parts we had after inventory
            this.missing = this.pieces - this.invParts;
            // number of pieces missing from the set
            this.notes = notes;
            // text string from admin input
            this.parts = [];
            // array of all parts in the set that comes when parts button is clicked
            this.instructions = instructions;
            this.displayStatus = '';


            return this;
        };


        let sets = [];
        let partySets = [];
        let partySetInfo = [];
        console.log(partySets);

        return {

            // Gets all sets from database and pushes them through the Set constructor and into the sets array
            // Returns the array of sets.
            getSets() {

                $http.get("/sets").then(function (response) {
                    // $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);


                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        item[i] = new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                        if (item[i].status === "CHECKED_OUT") {
                            item[i].displayStatus = "Checked Out"
                        } else
                            if (item[i].status === "MISSING_PIECES") {
                                item[i].displayStatus = "Missing Pieces";
                            } else
                                if (item[i].status === "ON_DISPLAY") {
                                    item[i].displayStatus = "On Display";
                                } else {
                                    item[i].displayStatus = "Available";

                                }
                    }
                    angular.copy(response.data.setViews, sets);


                });

                return sets;
            },

            // Gets the lists of filters for the search dropdowns, returns a promise and the response
            getFilters() {
                return $http.get("/filters/").then(function (response) {
                    console.log(response);
                    return response.data;
                })
            },

            // Gets the sets that match the search filters, puts them through the constructor and into the sets array for display
            // Returns the sets array/
            getSearchSets(nameFilter, numFilter, themeFilter, levelFilter, statFilter) {
                $http.get("/sets/?setName=" + nameFilter + "&setNum=" + numFilter + "&theme=" + themeFilter + "&status=" + statFilter + "&skill=" + levelFilter).then(function (response) {

                    console.log(response);


                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        item[i] = new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                            if (item[i].status === "CHECKED_OUT") {
                            item[i].displayStatus = "Checked Out"
                        } else
                            if (item[i].status === "MISSING_PIECES") {
                                item[i].displayStatus = "Missing Pieces";
                            } else
                                if (item[i].status === "ON_DISPLAY") {
                                    item[i].displayStatus = "On Display";
                                } else {
                                    item[i].displayStatus = "Available";

                                }
                    }
                    angular.copy(response.data.setViews, sets);
                });

                return sets;
            },

            getSet(id) {

                return $http.get("/set/" + id).then(function (response) {
                    let item = response.data.setViews[0];
                    item = new Set(item.set_id, item.name, item.set_num, item.theme,
                        item.num_parts, item.status, item.set_img_url, item.year,
                        item.skill_level, item.inv_date, item.inv_name, item.inv_stat, item.inv_parts,
                        item.last_checkout, item.set_build_url, item.notes);
                    console.log(response);
                    return item;
                })
            },

            addSet(num) {

                return $http.post("/add-set/" + num).then(function (response) {
                    console.log(response);
                    return response.data;
                })
            },


            showParts(item) {
                $http.get("/parts/" + item.setId).then(function (response) {
                    angular.copy(response.data.parts, item.parts)
                    console.log(response);
                })
            },


            changeStatus(set, status) {

                if (status === "AVAILABLE") {
                    status = "CHECKED_OUT";
                    // return status;
                } else {
                    status = "AVAILABLE";
                };
                $http.post("/set/status/" + set + "/?status=" + status).then(function (response) {
                });
                return status;
            },


            updateQty(set, id, update) {
                const array = [id, update];
                $http.post("/parts/" + set, array)
                    .then(function (response) {
                        console.log(response);

                    })
            },

            submitInv(set) {
                const array = [9999, 9999];
                $http.post("/parts/" + set, array)
                    .then(function (response) {
                        console.log(response);

                    })
            },

            sendUpdate(id, status, note) {
                const data = [status, note];
                $http.post("/set/" + id, data)
                    .then(function (response) {
                        console.log(response);

                    })
            },

            addPartySet(set) {
                partySets.push(set);
                return partySets;
            },


            getPartyInfo(array) {
                return $http.get("/sets").then(function (response) {

                    console.log(response);

                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        for (let j = 0; j < array.length; j++) {
                            if (parseInt(array[j]) === parseInt(item[i].set_num)) {
                                partySetInfo.push(new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                                    item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                                    item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                                    item[i].last_checkout, item[i].set_build_url, item[i].notes));
                            }
                        }
                    }
                    console.log(partySetInfo);
                    return partySetInfo;

                });

                return sets;

            },

            deleteSet(id) {
                $http.post("/delete-set/" + id).then(function (response) {

                    console.log(response);
                })
            },

            newCamper(person, time) {
                // $http.post("/campers/").then(function (response) {

                //     console.log(response);
                // })
            },

        };

    },
};

