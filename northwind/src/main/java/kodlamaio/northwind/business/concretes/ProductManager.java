package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service
public class ProductManager  implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>>getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");			
	}
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}
	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");
	}
	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}

}
