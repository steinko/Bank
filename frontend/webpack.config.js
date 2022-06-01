const webpack = require('webpack')
const path = require('path')
 const HtmlWebpackPlugin = require('html-webpack-plugin');


module.exports = {
 
  entry: { 
	       index: "./src/server/index.js",
  },

  output: {
	globalObject: 'this',
	publicPath: '/',
    path: path.resolve(__dirname, "server-build"),
    filename: "index.js",
  },

  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
         exclude: /node_modules/,
        use: "babel-loader",
      },
    ],
  },

  resolve: {
    extensions: ['*', '.js', '.jsx'],
  },
}