import React from 'react'
import Search from 'antd/lib/input/Search';

export const SearchComponent = ({onSearch}) => {
   
       
    return (
        <div>
            <Search style={{marginBottom : "8%"}} placeholder="input search text"  onSearch={onSearch}/>   
            
        </div>
    )
}
