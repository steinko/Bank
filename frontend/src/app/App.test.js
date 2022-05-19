import React from 'react';
import { render,screen } from '@testing-library/react';
import App from './App';


import { rest } from 'msw'
import { setupServer } from 'msw/node'

const server = setupServer(
 
   rest.get('https://localhost:9000/customers', (req,res,ctx) => {
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
  server.listen()
})

afterAll(() => {
  server.close()
})

it(' should display customers name', async () => {
    render(<App />)
    expect(await screen.findByText(/26076144574/i)).toBeInTheDocument()
})