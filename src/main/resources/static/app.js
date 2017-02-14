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




},{"./components/aboutPage":2,"./components/accountPage":3,"./components/adminPage":4,"./components/detailsPage":5,"./components/displayResults":6,"./components/homePage":7,"./components/instructionsPage":8,"./components/partsPage":9,"./components/registerPage":10,"./components/setsPage":11,"./controllers/aboutPageController":12,"./controllers/accountPageController":13,"./controllers/adminPageController":14,"./controllers/detailsPageController":15,"./controllers/displayResultsController":16,"./controllers/homePageController":17,"./controllers/instructionsPageController":18,"./controllers/partsPageController":19,"./controllers/registerPageController":20,"./controllers/setsPageController":21,"./services/CampService":22}],2:[function(require,module,exports){
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

},{}],10:[function(require,module,exports){
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
},{}],11:[function(require,module,exports){
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
},{}],12:[function(require,module,exports){
module.exports = {

    name: "aboutPageController",
    func: function ($scope, CampService) {

        //  console.log('about page controller working');
            
        

    },
}
},{}],13:[function(require,module,exports){
module.exports = {

    name: "accountPageController",
    func: function ($scope, CampService) {

        //  console.log('account page controller working');
            
        

    },
}
},{}],14:[function(require,module,exports){
module.exports = {

    name: "adminPageController",
    func: function ($scope, CampService) {


        $scope.setNumber = '';
        $scope.setId = '';

        $scope.newSet = function () {
            CampService.addSet($scope.setNumber);
        }

        $scope.removeSet = function(){
                       
            CampService.deleteSet($scope.setId);
        }


       

        // console.log('admin page controller working');


    },
}
},{}],15:[function(require,module,exports){
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




},{}],16:[function(require,module,exports){
module.exports = {

    name: "displayResultsController",
    func: function ($scope, CampService) {

       
            // console.log('display results controller working');
        

    },
}




},{}],17:[function(require,module,exports){
module.exports = {

    name: "homePageController",
    func: function ($scope, CampService) {

        //  console.log('home page controller working');
            
        

    },
}
},{}],18:[function(require,module,exports){
module.exports = {

    name: "instructionsPageController",
    func: function ($scope, CampService, $stateParams) {

       const partSet = ($stateParams.single);
       console.log("parts");
       $scope.partSet = CampService.getSet(partSet);
       console.log($scope.partSet);

       $scope.instructions = $scope.partSet.instructions;
       console.log($scope.instructions);
       
            // console.log('parts page controller working');
        

    },
}
},{}],19:[function(require,module,exports){
module.exports = {

    name: "partsPageController",
    func: function ($scope, CampService, $stateParams) {

       const partSet = ($stateParams.single);
       console.log("parts");
       $scope.partSet = CampService.getSet(partSet);
       console.log($scope.partSet);

       $scope.parts = $scope.partSet.parts;
       console.log($scope.parts);
           
           
            // console.log('parts page controller working');
        

    },
}


},{}],20:[function(require,module,exports){
module.exports = {

    name: "registerPageController",
    func: function ($scope, CampService) {

        //  console.log('register page controller working');
            
        

    },
}
},{}],21:[function(require,module,exports){
module.exports = {

    name: "setsPageController",
    func: function ($scope, CampService) {


// all of these arrays will be populated from the initial page load JSON response

        $scope.levels = ['Beginner', 'Intermediate', 'Advanced', 'Expert'];

        $scope.available = ['Available', 'Checked Out', 'Missing Pieces', 'On Display'];

        $scope.themes = ['Advanced Models', 'Agents', 'Alien Conquest', 'Aqua Raiders', 'Architecture', 'Atlantis', 'Batman', 'Bionicle', 'Cars2', 'Castle',
            'Chima', 'City', 'Creator', 'Dino', 'Friends', 'Galaxy Squad', 'Ghostbusters', 'Harry Potter', 'Hero Factory', 'Hobbit', 'Ideas', 'Indiana Jones', 'Lego Movie',
            'Lone Ranger', 'Lord of the Rings', 'Mars Mission', 'Minecraft', 'Monster Fighters', 'Ninjago', 'Power Miners', 'Prince of Persia', 'Racers', 'Scooby Doo', 'Space Police',
            'Speed Champions', 'Spongebob', 'Sports', 'Star Wars', 'Super Heroes', 'Technic', 'Teenage Mutant Ninja Turtles',
            'The Simpsons', 'Toy Story', 'Ultra Agents', 'Vintage', 'Wall-E'];

        $scope.viewSets = function () {
            $scope.sets = CampService.getSets();
            console.log($scope.sets);
        };





        // console.log('sets page controller working');



    },
}
},{}],22:[function(require,module,exports){
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
        }
    },
};


},{}]},{},[1]);
