const webpack = require('webpack')
const path = require('path')

module.exports = {
  mode: 'development',
  target: 'node',
  entry: "./src/server/index.js",

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