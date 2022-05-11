const webpack = require('webpack')
const path = require('path')


module.exports = {
  mode: 'development',
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
plugins: [new webpack.HotModuleReplacementPlugin()],
devServer: {
    static: path.resolve("server-build"),
    hot: true,
  },
};