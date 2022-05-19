import React from 'react'
import { render, screen } from '@testing-library/react'
import Customers from './Customers'
import { rest } from 'msw'
import { setupServer } from 'msw/node'

const server = setupServer(
 
   rest.get('https://localhost:9000/customers', (req,res,ctx) => {
		return  res ( ctx.status(200,'Customers returned'),ctx.json([{personId:26076144574, name:"Stein Korsveien"}, {personId:11036344574, name:"Oddmund Korsveien"}]))
		 }
    )
)

beforeEach(() => {
  server.listen()
})

afterEach(() => {
  server.close()
})


xit ('should exist',   () => { 
    render(<Customers />)
})


xit ('should exist as fisrt element in customer list', async () => { 
      render(<Customers />) 
      expect( await screen.findByText('Customers')).toBeInTheDocument()
})

it ('should exist as fisrt element in customer list', async () => {  
      render(<Customers />)
      expect(await screen.findByText(/26076144574/i)).toBeInTheDocument()
})

it ('should exist as  seconed element in customer list', async  () => {  
    render(<Customers />)
    expect( await screen.findByText(/11036344574/i)).toBeInTheDocument()
})

xit ('should not exist in customer list', async () => { 
    render(<Customers />)
    expect( await screen.findByText(/07126744574/i)).not.toBeInTheDocument()
})