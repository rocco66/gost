module.exports = function(grunt) {
  grunt.initConfig({
    pkg: grunt.file.readJSON("package.json"),
    jade: {
      options: {
        client: false,
        data: {
            debug: false
        }
      },
      index: {
        files: [{
            expand: true,
            dest: "dist/",
            src: "**/*.jade",
            ext: ".html",
            cwd: "src"

        }]
      }
    },
    clean: {
      before: ["dist/"],
      after: [".temp/"],
    },
    concat: {
      vendor_js: {
        options: {
          process: false
        },
        files: {
          "dist/js/vendor.js": [
            "bower_components/angular/angular.js",
            "bower_components/angular-ui-bootstrap/dist/ui-bootstrap-tpls-0.6.0.js.manually"
            // "bower_components/angular-ui/build/angular-ui.js"
          ],
        }
      },
      vendor_css: {
        files: {
          "dist/css/vendor.css": [
            "bower_components/angular-ui/build/angular-ui.min.css",
            "bower_components/bootstrap/dist/css/bootstrap.min.css"
          ],
        }
      }
    },
    shell: {
        options: {
            stdout: true,
            stderr: true,
        },
        cljs_once: {
            command: "lein cljsbuild once"
        },
    },
    stylus: {
      compile: {
        options: {
          // use: [
          //   require('fluidity')
          // ],
      },
      files: {
        'dist/css/gost.css': 'src/**/*.styl',
        }
      }
    }
  })

  grunt.loadNpmTasks("grunt-contrib-concat");
  grunt.loadNpmTasks("grunt-contrib-jade");
  grunt.loadNpmTasks("grunt-contrib-clean");
  grunt.loadNpmTasks('grunt-contrib-stylus');
  grunt.loadNpmTasks("grunt-shell");

  grunt.registerTask("build", ["clean:before",
                               "jade:index",
                               "concat:vendor_js",
                               "concat:vendor_css",
                               "stylus:compile",
                               "shell:cljs_once"
                               ])
}
