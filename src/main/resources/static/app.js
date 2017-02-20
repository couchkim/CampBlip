(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
const app = angular.module('CampApp', ['ui.router']);
// const app = angular.module('CampApp', ['ui.router'], ['ngEmbed']);


app.config(function ($stateProvider) {

    $stateProvider.state({
        name: 'home-page',
        url: '/home',
        component: 'homePage',
    });

    // home page for the site

    $stateProvider.state({
        name: 'admin-page',
        url: '/admin',
        component: 'adminPage',
    });

    // admin page will be landing page after successful login too

    $stateProvider.state({
        name: 'register-page',
        url: '/register',
        component: 'registerPage',
    });

    // register for a camp session

    $stateProvider.state({
        name: 'sets-page',
        url: '/sets',
        component: 'setsPage',
    });

    // search for sets

    $stateProvider.state({
        name: 'details-page',
        url: '/details/:single',
        component: 'detailsPage',
    });

    // see details on a single set

    $stateProvider.state({
        name: 'parts-page',
        url: '/parts/:single',
        component: 'partsPage',
    });

    // see all parts for a single set

    $stateProvider.state({
        name: 'account-page',
        url: '/account',
        component: 'accountPage',
    });

    // handles login or create new account

    $stateProvider.state({
        name: 'instructions-page',
        url: '/instructions/:single',
        component: 'instructionsPage',
    });

    $stateProvider.state({
        name: 'about-page',
        url: '/about',
        component: 'aboutPage',
    });

    $stateProvider.state({
        name: 'parties-page',
        url: '/parties',
        component: 'partiesPage',
    });

    $stateProvider.state({
        name: 'home',
        url: '',
        component: 'homePage',
    });

});


const controllers = [
    require('./controllers/homePageController'),
    require('./controllers/adminPageController'),
    require('./controllers/setsPageController'),
    require('./controllers/registerPageController'),
    require('./controllers/displayResultsController'),
    require('./controllers/detailsPageController'),
    require('./controllers/partsPageController'),
    require('./controllers/accountPageController'),
    require('./controllers/instructionsPageController'),
    require('./controllers/aboutPageController'),
    require('./controllers/partiesPageController'),



];

for (let i = 0; i < controllers.length; i++) {
    // console.log(controllers[i].name)
    app.controller(controllers[i].name, controllers[i].func);
};

const components = [
    require('./components/homePage'),
    require('./components/adminPage'),
    require('./components/setsPage'),
    require('./components/registerPage'),
    require('./components/displayResults'),
    require('./components/detailsPage'),
    require('./components/partsPage'),
    require('./components/accountPage'),
    require('./components/instructionsPage'),
    require('./components/aboutPage'),
    require('./components/partiesPage'),

];

for (let i = 0; i < components.length; i++) {
    app.component(components[i].name, components[i].object);
};

const services = [
    require('./services/CampService'),
];

for (let i = 0; i < services.length; i++) {
    console.log(services[i].name)
    app.factory(services[i].name, services[i].func);
};




},{"./components/aboutPage":2,"./components/accountPage":3,"./components/adminPage":4,"./components/detailsPage":5,"./components/displayResults":6,"./components/homePage":7,"./components/instructionsPage":8,"./components/partiesPage":9,"./components/partsPage":10,"./components/registerPage":11,"./components/setsPage":12,"./controllers/aboutPageController":13,"./controllers/accountPageController":14,"./controllers/adminPageController":15,"./controllers/detailsPageController":16,"./controllers/displayResultsController":17,"./controllers/homePageController":18,"./controllers/instructionsPageController":19,"./controllers/partiesPageController":20,"./controllers/partsPageController":21,"./controllers/registerPageController":22,"./controllers/setsPageController":23,"./services/CampService":24}],2:[function(require,module,exports){
module.exports = {

    name: 'aboutPage',
    object: {

        templateUrl: 'components/aboutPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'aboutPageController',
    }

};
},{}],3:[function(require,module,exports){
module.exports = {

    name: 'accountPage',
    object: {

        templateUrl: 'components/accountPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'accountPageController',
    }

}
},{}],4:[function(require,module,exports){
module.exports = {

    name: 'adminPage',
    object: {

        templateUrl: 'components/adminPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'adminPageController',
    }

}
},{}],5:[function(require,module,exports){
module.exports = {

    name: 'detailsPage',
    object: {

        templateUrl: 'components/detailsPage.html',
        bindings: {
            
        },
        controller: 'detailsPageController',
    }

}


},{}],6:[function(require,module,exports){
module.exports = {

    name: 'displayResults',
    object: {

        templateUrl: 'components/displayResults.html',
        bindings: {
            item: '<',
            onClick: '&', 
        },
        controller: 'displayResultsController',
    }

}
},{}],7:[function(require,module,exports){
module.exports = {

    name: 'homePage',
    object: {

        templateUrl: 'components/homePage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'homePageController',
    }

}
},{}],8:[function(require,module,exports){
module.exports = {

    name: 'instructionsPage',
    object: {

        templateUrl: 'components/instructionsPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'instructionsPageController',
    }

}
},{}],9:[function(require,module,exports){
module.exports = {

    name: 'partiesPage',
    object: {

        templateUrl: 'components/partiesPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'partiesPageController',
    }

}

},{}],10:[function(require,module,exports){
module.exports = {

    name: 'partsPage',
    object: {

        templateUrl: 'components/partsPage.html',
        bindings: {
            // item: '<',
            // onClick: '&', 
        },
        controller: 'partsPageController',
    }

}

},{}],11:[function(require,module,exports){
module.exports = {

    name: 'registerPage',
    object: {

        templateUrl: 'components/registerPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'registerPageController',
    }

}
},{}],12:[function(require,module,exports){
module.exports = {

    name: 'setsPage',
    object: {

        templateUrl: 'components/setsPage.html',
        bindings: {
            // label: '<', 

        },
        controller: 'setsPageController',
    }

}
},{}],13:[function(require,module,exports){
module.exports = {

    name: "aboutPageController",
    func: function ($scope, CampService) {

        //  console.log('about page controller working');
            
        

    },
}
},{}],14:[function(require,module,exports){
module.exports = {

    name: "accountPageController",
    func: function ($scope, CampService) {

        //  console.log('account page controller working');
            
        

    },
}
},{}],15:[function(require,module,exports){
module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';
        $scope.newCamper = '';
        $scope.weeks = '';
        $scope.newInfo = null;
        

        $scope.newSet = function () {
            CampService.addSet($scope.setNumber).then(function(response){
                $scope.newInfo = response;
                console.log(response);
            })
                ;
            console.log($scope.newInfo);
            $scope.setNumber = '';
           
        }

        $scope.removeSet = function(){
                       
            CampService.deleteSet($scope.setId);
        }

        $scope.addCamper = function(){
            CampService.newCamper($scope.newCamper, $scope.weeks);
        }

    },
}
},{}],16:[function(require,module,exports){
module.exports = {

    name: "detailsPageController",
    func: function ($scope, CampService, $stateParams) {


        $scope.campers = ['Wilson Rhee', 'Carter Bateman', 'Collier McElroy',
            'Alexander Paschal', 'Holden Harrell'];

        $scope.camperList = '';
        $scope.newNote = '';
        $scope.byStatus = '';
        $scope.available = [];


        const id = ($stateParams.single);

        $scope.item = CampService.getSet(id);
        console.log($scope.item);


        $scope.getParts = function (item) {
            CampService.showParts(item);
            console.log(CampService.showParts(item));
        }

        $scope.checkToggle = function () {
            $scope.item.status = CampService.changeStatus($scope.item.setId, $scope.item.status);
        }

         CampService.getFilters().then(function (response) {  
            $scope.available = response.status;
            console.log(response);
        });

        $scope.updateSet = function (set){
            CampService.sendUpdate(set, $scope.byStatus, $scope.newNote);
        }



    },
}




},{}],17:[function(require,module,exports){
module.exports = {

    name: "displayResultsController",
    func: function ($scope, CampService) {

       
        
        

    },
}




},{}],18:[function(require,module,exports){
module.exports = {

    name: "homePageController",
    func: function ($scope, CampService) {

        //  console.log('home page controller working');
            
        

    },
}
},{}],19:[function(require,module,exports){
module.exports = {

    name: "instructionsPageController",
    func: function ($scope, $sce, $http, CampService, $stateParams) {

        const partSet = ($stateParams.single);
        console.log("parts");

        $scope.partSet = CampService.getSet(partSet);
        console.log($scope.partSet);

        $scope.instructions = $scope.partSet.instructions;
        // $scope.instructions = $sce.trustAsResourceUrl($scope.partSet.instructions);
        // $http.get($scope.instructions, { responseType: 'arraybuffer' })
        //     .then(function (response) {
        //         const pdf = new Blob([response.data], {
        //             type: 'application/pdf',
        //         });

        //         const url = URL.createObjectURL(pdf);
        //         $scope.knowledge = $sce.trustAsResourceUrl(url);
        //         console.log(url);
        //     });
        // console.log($scope.instructions);



    },
}
},{}],20:[function(require,module,exports){
module.exports = {

    name: "partiesPageController",
    func: function ($scope, CampService) {

        
            
        

    },
}
},{}],21:[function(require,module,exports){
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
      

       $scope.changeQty = function(set, part){
              part.currInv = part.setQty;
              CampService.updateQty(set, part.setPartId, part.currInv);
              console.log(set, part.setPartId, part.currInv);

       };

         $scope.sendQty = function(set, part){   
           CampService.updateQty(set, part.setPartId, part.currInv);
           console.log(set, part.setPartId, part.currInv);

         };

         $scope.finalQty = function(set){   
           CampService.submitInv(set);
           

         };
        

    },
}


},{}],22:[function(require,module,exports){
module.exports = {

    name: "registerPageController",
    func: function ($scope, CampService) {

        //  console.log('register page controller working');
            
        

    },
}
},{}],23:[function(require,module,exports){
module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {



        $scope.levels = [];
        $scope.available = [];
        $scope.themes = [];


        $scope.byName = '';
        $scope.byNumber = '';
        $scope.byTheme = '';
        $scope.byLevel = '';
        $scope.byStatus = '';
        $scope.filters = '';

        // CampService.getSets();

        CampService.getFilters().then(function (response) {
            $scope.levels = response.skills;
            $scope.available = response.status;
            $scope.themes = response.themes;

            console.log(response);
        });



        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };

        $scope.viewSearchSets = function () {
            $scope.sets = CampService.getSearchSets($scope.byName, $scope.byNumber,
                $scope.byTheme, $scope.byLevel, $scope.byStatus);
            
            console.log($scope.sets);
        };


    },
}
},{}],24:[function(require,module,exports){
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
            this.missing = 0;
            // number of pieces missing from the set
            // this.order = 'lots of pieces';
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
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                    }
                    angular.copy(response.data.setViews, sets);


                });

                return sets;
            },

            getSearchSets(nameFilter, numFilter, themeFilter, levelFilter, statFilter) {
                $http.get("/sets/?setName=" + nameFilter + "&setNum=" + numFilter + "&theme=" + themeFilter + "&status=" + statFilter + "&skill=" + levelFilter).then(function (response) {
                    // $http.get("https://camp-blip-legos.herokuapp.com/sets").then(function (response) {
                    console.log(response);


                    for (let i = 0; i < response.data.setViews.length; i++) {
                        let item = response.data.setViews;
                        item[i] = new Set(item[i].set_id, item[i].name, item[i].set_num, item[i].theme,
                            item[i].num_parts, item[i].status, item[i].set_img_url, item[i].year,
                            item[i].skill_level, item[i].inv_date, item[i].inv_name, item[i].inv_stat, item[i].inv_parts,
                            item[i].last_checkout, item[i].set_build_url, item[i].notes);

                    }

                    angular.copy(response.data.setViews, sets);


                });

                return sets;
            },

            getSet(id) {
                // if length is 0, make getSets request and then iterate over it.  promises
                for (let i = 0; i < sets.length; i++) {
                    // if (sets.length === 0){
                    //     getSets();
                    // }
                    if (sets[i].setNumber === id) {
                        return sets[i];
                    }
                }
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


            getFilters() {
                return $http.get("/filters/").then(function (response) {
                    console.log(response);
                    return response.data;
                })
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

            sendUpdate(set, status, note) {
                const data = [status, note];
                 $http.post("/sets/" + set, data)
                 .then(function (response) {
                    console.log(response);
                 
                })
            },
        };

    },
};


},{}]},{},[1]);
