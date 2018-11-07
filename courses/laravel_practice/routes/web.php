<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// });
//
// Route::get('/example', function () {
//     return "Hello, World!";
// });
//
// // Assign Variables in Route
// Route::get('/posts/{id}/{name}', function ($id, $name) {
//     return "This is post number" . $id . " " . $name;
// });
//
// // Naming Route using array
// Route::get('/admin/posts/example', array('as' => 'admin.home', function () {
//     $url = route('admin.home');
//
//     return "This url is " . $url;
// }));

// Routing Controller passing data
// Route::get('/posts/{id}', 'PostsController@index');

// Creating Routes using resource
Route::resource('posts', 'PostsController');


Route::get('/contact', 'PostsController@contact');

Route::get('/post/{id}/{name}', 'PostsController@show_post');
