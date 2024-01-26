function showFormCreate() {
    document.getElementById('main').innerHTML = `
    <div>
    <input type="text" id="name" placeholder="Name">
    <input type="text" id="price" placeholder="Price">
    <input type="text" id="quantity" placeholder="Quantity">
    <input type="text" id="categoryID" placeholder="Category Id">
    <button onclick="create()">Thêm mới</button>
</div>
    `
}

function create() {
    let name = document.getElementById('name').value;
    let age = document.getElementById('price').value;
    let email = document.getElementById('quantity').value;
    let cityID = document.getElementById('categoryID').value;

    let newProduct = {
        name: name,
       price: price,
        quantity:quantity,
        category: {
            id: categoryID
        }
    }

    axios.post('http://localhost:8080/products', newProduct).then(function (response) {
        showHome();
    })
}