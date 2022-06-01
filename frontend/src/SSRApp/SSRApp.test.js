import React from 'react';
import { render,screen } from '@testing-library/react';
import SSRApp from './SSRApp';


import { rest } from 'msw'
import { setupServer } from 'msw/node'
import {backendUrl} from '../services/BackendUrl'

const server = setupServer(
 
   rest.get(backendUrl(), (req,res,ctx) => {
		return  res ( 
			           ctx.status(200,'Customers returned'),
		               ctx.json( 
			                     [{personId:26076144574, name:"Stein Korsveien"}, {personId:26076144554, name:"Oddmund Korsveien"}]
                               )
                     )
		 }
    )
)

beforeAll(() => {
  process.env.BACKEND_URL = "http://localhost:9000"
  server.listen()
})

afterAll(() => {
  server.close()
})

it(' should display customers name', async () => {
	 process.env.BACKEND_URL = "http://localhost:9000"
    render(<SSRApp />)
    expect(await screen.findByText(/26076144574/i)).toBeInTheDocument()
})