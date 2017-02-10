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
    console.log(controllers[i].name)
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



