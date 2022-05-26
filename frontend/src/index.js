import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './app/App';
import * as serviceWorker from './serviceWorker'
const { worker } = require('./mocks/browser')

console.log(process.env.REACT_APP_USE_MSW)  // eslint-disable-line
const useMock = process.env.REACT_APP_USE_MSW  // eslint-disable-line

if (useMock) {
    worker.start()
}

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
