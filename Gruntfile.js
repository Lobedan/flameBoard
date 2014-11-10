'use strict';
module.exports = function (grunt) {

	require('time-grunt')(grunt);
	require('load-grunt-tasks')(grunt, {
		pattern: ['grunt-*', '!grunt-template-jasmine-istanbul']
	});

	grunt.initConfig({
		                 bower: {
			                 test: {
				                 options: {
					                 cleanTargetDir: false,
					                 cleanBowerDir: true,
					                 install: false,
					                 copy: true,
					                 /*verbose: true,*/
					                 layout: 'byComponent',
					                 targetDir: "src/test/webapp/vendor"
				                 }
			                 }
		                 },

		                 jasmine: {
			                 coverage: {
				                 src: ['src/main/resources/templates/main/js/**/*.js'],
				                 options: {
					                 keepRunner: true,
					                 specs: 'src/test/webapp/js/**/*.js',
					                 vendor: [
						                 /*'<%= meta.src.main.vendor %>/angular-scenario/angular-scenario.js'*/
						                 'src/test/webapp/vendor/angular/angular.js',
						                 'src/test/webapp/vendor/angular-route/angular-route.js',
						                 'src/test/webapp/vendor/angular-mocks/angular-mocks.js'
					                 ],
					                 template: require('grunt-template-jasmine-istanbul'),
					                 templateOptions: {
						                 /*                        template: require('grunt-template-jasmine-teamcity'),
						                  templateOptions: {
						                  output: '<%= meta.bin.coverage %>/html/jasmine.teamcity.log'
						                  },*/
						                 coverage: 'build/reports/coverage/coverage.json',
						                 report: [
							                 {
								                 type: 'html',
								                 options: {
									                 dir: 'build/reports/coverage/html'
								                 }
							                 },
							                 {
								                 type: 'cobertura',
								                 options: {
									                 dir: 'build/reports/coverage/cobertura'
								                 }
							                 },
							                 {
								                 type: 'text-summary'
							                 }
						                 ]
					                 }
				                 }
			                 }
		                 },

		                 coffee: {
			                 build: {
				                 options: {
					                 bare: true,
					                 sourceMap: true
				                 },
				                 expand: true,
				                 cwd: 'src/main/webapp/coffee/',
				                 src: ['**/*.coffee'],
				                 dest: 'src/main/resources/templates/main/js',
				                 ext: '.js'
			                 },

			                 test: {
				                 options: {
					                 bare: true,
					                 sourceMap: true
				                 },
				                 expand: true,
				                 cwd: 'src/test/webapp/coffee/',
				                 src: ['*Spec.coffee'],
				                 dest: 'src/test/webapp/js',
				                 ext: '.js'
			                 }
		                 },

		                 sass: {
			                 build: {
				                 files: [{
					                         expand: true,
					                         cwd: 'src/main/webapp/sass/',
					                         src: ['**/*.sass'],
					                         dest: 'src/main/resources/templates/css/',
					                         ext: '.css'
				                         }]
			                 }
		                 }

	                 });


	grunt.registerTask('src', ['sass:build', 'coffee:build']);
	grunt.registerTask('test', ['bower', 'coffee:test', 'jasmine']);
	grunt.registerTask('build', ['test', 'src']);
	grunt.registerTask('default', ['build']);
};