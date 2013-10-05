module.exports = (grunt) ->
  grunt.initConfig
    pkg: grunt.file.readJSON "package.json"
    jade:
      options:
        client: false
        data:
          debug: false
      all:
        files: [
            expand: true
            dest: "dist/"
            src: "**/*.jade"
            ext: ".html"
            cwd: "src"
        ]
    clean:
      before: ["dist/"]
      after: [".temp/"]
    concat:
      vendor_js:
        options:
          process: false
        files:
          "dist/js/vendor.js": [
            "bower_components/angular/angular.js"
            "bower_components/angular-ui-bootstrap/dist/ui-bootstrap-tpls-0.6.0.js.manually"
            "bower_components/angular-fire/angularfire.min.js"
          ],
      vendor_css:
        files:
          "dist/css/vendor.css": [
            "bower_components/angular-ui/build/angular-ui.min.css"
            "bower_components/bootstrap/dist/css/bootstrap.min.css"
          ]
    shell:
        options:
            stdout: true
            stderr: true
        cljs_once:
            command: "lein cljsbuild once 2&>1"
        cljs_auto:
            command: "lein cljsbuild auto 2&>1"
    stylus:
      compile:
        files:
          'dist/css/gost.css': 'src/**/*.styl'
    watch:
      options:
        livereload: true
      clojurescript:
        files: ['dist/**/*.js']
      templates:
        files: ['src/**/*.jade']
        tasks: ['jade:all']
      style:
          files: ['src/**/*.styl']
          tasks: ['stylus:compile']
    concurrent:
      options:
        logConcurrentOutput: true
      watch_all: ["watch", "shell:cljs_auto"]


  grunt.loadNpmTasks("grunt-contrib-concat")
  grunt.loadNpmTasks("grunt-contrib-jade")
  grunt.loadNpmTasks("grunt-contrib-clean")
  grunt.loadNpmTasks('grunt-contrib-watch')
  grunt.loadNpmTasks('grunt-contrib-stylus')
  grunt.loadNpmTasks('grunt-concurrent')
  grunt.loadNpmTasks("grunt-shell")

  grunt.registerTask "watch_all", "concurrent:watch_all"
  grunt.registerTask("build", ["clean:before"
                               "jade:all"
                               "concat:vendor_js"
                               "concat:vendor_css"
                               "stylus:compile"
                               "shell:cljs_once"
                               ])
