import React from 'react';
import { render, screen } from '@testing-library/react';
import Customers from './Customers';


it ('should exist', async  () => { 
    let { getByText } = render(<Customers />)
   await  expect(getByText).not.toBeNull()
})


it ('should exist as fisrt element in customer list', () => { 
      let { getByText } = render(<Customers />) 
      expect( getByText('Customers')).toBeInTheDocument()
})

it ('should exist as fisrt element in customer list', () => {  
    let { getByText } = render(<Customers />)
      expect( getByText(/Stein/)).toBeInTheDocument()
})

it ('should exist as  seconed element in customer list',  () => {  
    let { getByText } = render(<Customers />)
    expect( getByText(/Oddmund/)).toBeInTheDocument()
})

it ('should not exist in customer list',  () => { 
    let { queryByText } = render(<Customers />)
    expect( queryByText(/Anne/)).not.toBeInTheDocument()
})