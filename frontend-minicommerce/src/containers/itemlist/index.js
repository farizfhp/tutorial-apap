import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import Badge from "@material-ui/core/Badge";
import ViewStreamIcon from "@mui/icons-material/ViewStream";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import { Fab } from "@material-ui/core";

class ItemList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [],
      cartItems: {},
      cart: [],
      isLoading: false,
      isCreate: false,
      isEdit: false,
      isSearching: false,
      cartHidden: true,
      id: "",
      title: "",
      price: 0,
      description: "",
      category: "",
      quantity: 0,
      qtyInCart: 0,
      qtyToAdd: 0,
    };
    this.handleAddItem = this.handleAddItem.bind(this);
    this.loadCart = this.loadCart.bind(this);
    this.handleSearchButton = this.handleSearchButton.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleToggleCart = this.handleToggleCart.bind(this);
    this.handleCheckout = this.handleCheckout.bind(this);
    this.handleAddItemToCart = this.handleAddItemToCart.bind(this);
    // this.handleAddItemQty = this.handleAddItemQty.bind(this);
  }
  handleToggleCart = () => {
    const cartHidden = this.state.cartHidden;
    console.log(this.state);
    this.setState({ cartHidden: !cartHidden });
  };
  //   handleAddItemToCart = (item) => {
  //     const newItems = [...this.state.cartItems];
  //     const newItem = { ...item };
  //     const targetInd = newItems.findIndex((it) => it.id === newItem.id);
  //     if (targetInd < 0) {
  //       newItems.push(newItem);
  //     }
  //     this.setState({ cartItems: newItems });
  //   };
  // handleAddItemToCart = (item, qty) => {
  //   const newItems = { ...this.state.cartItems };
  //   console.log("newItems:", newItems);
  //   const newItem = { ...item };
  //   console.log(newItem);

  //   // const targetInd = newItems.findIndex((it) => it.id === newItem.id);
  //   // if (targetInd < 0) {
  //   if (!(item.id in newItems)) {
  //     newItem.inCart = true;
  //     // newItems.push(newItem);
  //     newItems[newItem.id] = qty;
  //     console.log("newItems dalem atas:", newItems);
  //     // item.qtyInCart = this.updateShopItem(newItem, true);
  //   } else {
  //     newItems[newItem.id] += qty;
  //     console.log("newItems else:", newItems);
  //   }
  //   this.setState({ cartItems: newItems });
  //   // console.log(this.state);
  // };
  // handleAddItemQty = (qty) => {
  //   this.setState({ qtyToAdd: qty });
  //   console.log("QTY TO ADDDDD: ", this.state.qtyToAdd);
  // };
  async handleAddItemToCart(item, qty) {
    // if
    var flag = false;
    if (item.quantity < qty) {
      flag = true;
      console.log("MASUK ATAS BRO");
    }
    for (const [key, value] of Object.entries(
      (await APIConfig.get("/cart")).data.result
    )) {
      console.log("masuk for");
      console.log(key, value);
      if (value.item.id == item.id) {
        console.log("MASUK SINI BROO");
        console.log("value: ", value.quantity);
        console.log("to add: ", +value.quantity + +qty);
        console.log("real quantity: ", item.quantity);
        if (+value.quantity + +qty > item.quantity) {
          console.log("MASUK SINI JUGA BROO");
          flag = true;
        }
      }
    }
    if (!flag) {
      const data = {
        idItem: item.id,
        quantity: qty,
      };
      try {
        await APIConfig.post("/cart", data);
      } catch {
        console.log("error");
      }
      console.log("data All: ", await APIConfig.get("/cart"));
      try {
        const { dataAll } = await APIConfig.get("/cart");
        console.log("dataAll :", dataAll);
      } catch {
        console.log("error");
      }
    } else {
      alert("Stok tidak cukup!");
    }
    this.loadCart();
    console.log("LOAD CART: ", this.state.cartItems);
  }
  async loadCart() {
    // const { data } = await APIConfig.get("/cart");
    console.log("LOAD CART ITEM LIST AWAAAL: ", this.state.cart);
    var dataTemp = {};
    var cartTemp = [this.state.cart];
    console.log("LOAD CART ITEM LIST KEDUA: ", cartTemp);

    for (const [key, value] of Object.entries(
      (await APIConfig.get("/cart")).data.result
    )) {
      console.log("masuk for loadcart");
      console.log(key, value);
      dataTemp[value.item.id] = value.quantity;
      if (value.item !== "undefined") {
        cartTemp.push(value.item);
      }
    }
    console.log("ISI NOL : ", cartTemp[0]);
    // if(cartTemp[0] == 0){
    cartTemp.splice(0, 1);
    // }
    console.log("DATATEMP: ", dataTemp);
    console.log("CARTTEMP: ", cartTemp);
    this.setState({ cartItems: dataTemp, cart: cartTemp });
    console.log("LOAD CART: ", this.state.cartItems);
    console.log("LOAD CART ITEM LIST: ", this.state.cart);
  }
  async handleCheckout() {
    await APIConfig.get("/cart/checkout");
    this.setState({ cartItems: {}, cart: [] });
    this.loadData();
  }
  handleDeleteItemFromCart = (item) => {
    this.increaseBalance(item.price);
    const cartItems = [...this.state.cartItems];
    const newItem = { ...item };
    const targetInd = cartItems.findIndex((it) => it.id === newItem.id);
    if (targetInd >= 0) {
      newItem.inCart = false;
      cartItems.splice(targetInd, 1);
      // this.updateShopItem(newItem, false);
    }
    this.setState({ cartItems: cartItems });
  };
  updateShopItem = (item, inCart) => {
    const tempShopItems = this.state.cartItems;
    const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
    console.log(tempShopItems[targetInd]);
    if (!inCart) {
      tempShopItems[item.id].inCart = inCart;
    }
    this.setState({ cartItems: tempShopItems });
  };
  handleAddItem() {
    this.setState({ isCreate: true });
    // console.log(this.state.isSearching)
  }
  handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate: false, isEdit: false, isSearching: false });
    this.loadData();
  }
  handleClickLoading() {
    const currentLoading = this.state.isLoading;
    this.setState({ isLoading: !currentLoading });
    console.log(this.state.isLoading);
  }
  componentDidMount() {
    console.log("componentDidMount()");
    this.loadData();
  }
  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate()");
    return true;
  }
  handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
    console.log("name: ", name, "   value: ", value);
  }
  handleEditItem(item) {
    this.setState({
      isEdit: true,
      id: item.id,
      title: item.title,
      price: item.price,
      description: item.description,
      category: item.category,
      quantity: item.quantity,
    });
  }
  async handleSubmitEditItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity,
      };
      await APIConfig.put(`/item/${this.state.id}`, data);
      this.setState({
        id: "",
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0,
      });
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    console.log(event);
    this.handleCancel(event);
  }
  async handleSubmitItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity,
      };
      await APIConfig.post("/item", data);
      this.setState({
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0,
      });
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");

      console.log(error);
    }
    this.handleCancel(event);
  }
  async loadData() {
    try {
      const { data } = await APIConfig.get("/item");
      this.setState({ items: data.result });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }
  handleSearchButton() {
    console.log("masuk X");
    this.setState({ isSearching: true });
    console.log("masuk Y");
    this.setState({ items: [] });
  }
  async handleSearch(event) {
    console.log("masuk A");
    event.preventDefault();
    try {
      console.log("masuk B");
      console.log(this.state);
      const title = this.state.title;
      console.log("masuk C");
      const { data } = await APIConfig.get("/item?title=" + title);
      console.log("masuk D");
      this.setState({ items: data.result });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }
  render() {
    return (
      <div className={classes.itemList}>
        <h1 className={classes.title}>All Items</h1>
        <div style={{ position: "fixed", top: 25, right: 25 }}>
          <Fab variant="extended" onClick={this.handleToggleCart}>
            {this.state.cartHidden ? (
              <Badge
                color="secondary"
                badgeContent={this.state.cart.length}
              >
                <ShoppingCartIcon />
              </Badge>
            ) : (
              <ViewStreamIcon />
            )}
          </Fab>
        </div>
        <Button action={this.handleAddItem}>Add Item</Button>
        <Button action={this.handleSearchButton}>Search</Button>
        <div>
          {!this.state.cartHidden ? (
            <div>
              <div>
                {this.state.cart.length != 0 ? (
                  <Button action={this.handleCheckout}>Checkout</Button>
                ) : (
                  <div></div>
                )}
              </div>
              <div className="col-sm">
                {this.state.cart.map((item) => (
                  <Item
                    key={item.id}
                    id={item.id}
                    title={item.title}
                    price={item.price}
                    description={item.description}
                    category={item.category}
                    quantity={item.quantity}
                    sumPrice={(item.price * this.state.cartItems[item.id])}
                    inCart={item.inCart}
                    qtyInCart={this.state.cartItems[item.id]}
                  />
                ))}
              </div>
            </div>
          ) : (
            <div className="col-sm">
              {this.state.items.map((item) => (
                <Item
                  key={item.id}
                  id={item.id}
                  title={item.title}
                  price={item.price}
                  description={item.description}
                  category={item.category}
                  quantity={item.quantity}
                  inCart={item.inCart}
                  isShopList={true}
                  handleEdit={() => this.handleEditItem(item)}
                  handleChange={(e) => this.handleChangeField(e)}
                  handleAdd={() =>
                    this.handleAddItemToCart(item, this.state.qtyToAdd)
                  }
                />
              ))}
            </div>
          )}
        </div>
        <Modal
          show={this.state.isSearching}
          handleCloseModal={this.handleCancel}
          modalTitle={"Search for items"}
        >
          <form>
            <input
              className={classes.textField}
              type="text"
              placeholder="Nama Item"
              name="title"
              value={this.state.title}
              onChange={this.handleChangeField}
            ></input>
          </form>
          <div>
            {this.state.items.map((item) => (
              <Item
                key={item.id}
                id={item.id}
                title={item.title}
                price={item.price}
                description={item.description}
                category={item.category}
                quantity={item.quantity}
              />
            ))}
          </div>
          <Button action={this.handleSearch}>Search</Button>
          <Button action={this.handleCancel}>Cancel</Button>
        </Modal>
        <Modal
          show={this.state.isCreate || this.state.isEdit}
          handleCloseModal={this.handleCancel}
          modalTitle={
            this.state.isCreate ? "Add Item" : `Edit Item ID ${this.state.id}`
          }
        >
          <form>
            <input
              className={classes.textField}
              type="text"
              placeholder="Nama Item"
              name="title"
              value={this.state.title}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="number"
              placeholder="Harga"
              name="price"
              value={this.state.price}
              onChange={this.handleChangeField}
            />
            <textarea
              className={classes.textField}
              placeholder="Deskripsi"
              name="description"
              rows="4"
              value={this.state.description}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="text"
              placeholder="Kategori"
              name="category"
              value={this.state.category}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="number"
              placeholder="qty"
              name="quantity"
              value={this.state.quantity}
              onChange={this.handleChangeField}
            />
            <Button
              action={
                this.state.isCreate
                  ? this.handleSubmitItem
                  : this.handleSubmitEditItem
              }
            >
              Create
            </Button>
            <Button action={this.handleCancel}>Cancel</Button>
          </form>
        </Modal>
      </div>
    );
  }
}
export default ItemList;
