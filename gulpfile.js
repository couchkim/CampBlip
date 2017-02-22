

// Step 1: import gulp
let gulp = require('gulp');
let sass = require('gulp-sass');
let browser = require('gulp-browser');

const BUILD_URL = 'build/resources/main/static';
const SRC_URL = 'src/main/resources/static';


// Step 2: create default task 
gulp.task('default', ['html', 'css', 'js', 'images']);

// Step 3: create subtasks
gulp.task('html', function () {
    // Now that I have a templates directory, I also need to copy 
    // those over.
    gulp.src('templates/*.html')
        .pipe(gulp.dest(`${BUILD_URL}/components`))
        .pipe(gulp.dest(`${SRC_URL}/components`));

    // index.html and other html files
    return gulp.src('*.html')
        .pipe(gulp.dest(BUILD_URL))
        .pipe(gulp.dest(SRC_URL));
});

gulp.task('images', function () {
    return gulp.src('images/*')
        .pipe(gulp.dest(`${BUILD_URL}/images`))
        .pipe(gulp.dest(`${SRC_URL}/images`));
});

gulp.task('css', function () {
    // Convert style.scss into style.css.
    // Copy to public/
    gulp.src('scss/printfriendly.scss')
        .pipe(sass())
        .pipe(gulp.dest(BUILD_URL))
        .pipe(gulp.dest(SRC_URL));

    return gulp.src('scss/style.scss')
        .pipe(sass())
        .pipe(gulp.dest(BUILD_URL))
        .pipe(gulp.dest(SRC_URL));
});

gulp.task('js', function () {
    // Copy js file into public/
    return gulp.src('js/app.js')
        .pipe(browser.browserify())
        .pipe(gulp.dest(BUILD_URL))
        .pipe(gulp.dest(SRC_URL));
});

gulp.task('watch', ['default'], function () {
    // When a js file in js/ changes, run 'js' task
    gulp.watch('js/*.js', ['js']);
    gulp.watch('js/*/*.js', ['js']);
    gulp.watch('scss/*.scss', ['css']);
    gulp.watch('*.html', ['html']);
    gulp.watch('templates/*.html', ['html']);
});


/**
 * RULE: replace 'public' with 
 *  - 'build/resources/main/static'
 *  - 'src/main/resources/static'
 * 
 * HTML
 * Starts in the root directory
 * Goes to src/main/resources/static
 * 
 * CSS
 * Starts in scss/
 * Goes to src/main/resources/static
 * 
 * JS
 * Starts in js/
 * Goes to src/main/resources/static
 */


