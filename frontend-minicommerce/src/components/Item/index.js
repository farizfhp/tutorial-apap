import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
import ItemList from "../../containers/itemlist";

const Item = (props) => {
  const {
    id,
    title,
    price,
    description,
    category,
    quantity,
    handleEdit,
    handleDelete,
    inCart,
    qtyInCart,
    handleAdd,
    isShopList,
    handleChange,
    qty,
    sumPrice
  } = props;
  return (
    <div className={classes.item}>
      <h3>{`ID ${id}`}</h3>
      <p>{`Nama Barang: ${title}`}</p>
      <p>{`Harga: ${price}`}</p>
      <p>{`Deskripsi: ${description}`}</p>
      <p>{`Kategori: ${category}`}</p>
      <p>{`stok: ${quantity}`}</p>
      <CustomIconButton
        // isShopList={isShopList}
        inCart={inCart}
        sumPrice={sumPrice}
        handleChange={handleChange}
        handleEdit={handleEdit}
        qtyInCart={qtyInCart}
        handleAdd={handleAdd}
        isShopList={isShopList}
      />
    </div>
  );
};
export default Item;

function CustomIconButton({ isShopList, inCart, handleChange, handleEdit, qtyInCart, handleAdd, qty, sumPrice }) {
  if (!isShopList) {
    if (inCart) {
      return null;
    }
    return (
      // <IconButton onClick={handleChange}>
      //   <AddShoppingCartIcon />
      // </IconButton>
      <div>
        <p>{`Total harga: ${sumPrice}`}</p>
        <p>{`di dalam Cart: ${qtyInCart}`}</p>
      </div>
    );
  } else {
    return (
      <div>
        <Button action={handleEdit}>Edit</Button>
        <div>
          <input
            className={classes.textField}
            type="number"
            placeholder="Jumlah"
            name="qtyToAdd"
            value= {qty}
            // value={ItemList.handleAddItemQty()} 
            onChange={handleChange}
          ></input>
          <Button type="submit" action={handleAdd}>Add to Cart</Button>
        </div>
      </div>
    );
  }
}
