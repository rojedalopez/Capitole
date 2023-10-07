package com.rojedalopez.capitole;

import com.rojedalopez.capitole.controller.PriceController;
import com.rojedalopez.capitole.domain.dto.PriceRequestDto;
import com.rojedalopez.capitole.domain.dto.PriceResponseDto;
import io.reactivex.rxjava3.observers.TestObserver;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CapitoleApplicationTests {
	@Autowired
	private PriceController controller;

	@Test
	void test1() throws Exception {

		var request = PriceRequestDto.builder()
									.brandId(1)
									.dateTime(LocalDateTime.of(2020, 6, 14, 10, 0, 0))
									.productId("35455")
									.build();


		TestObserver<PriceResponseDto> response = controller.getPrice(request).test();
		response.await();
		response.assertNoErrors();
		response.assertComplete();
		response.assertValue(value ->
			 value.getPrice().equals(new BigDecimal("35.50")) &&
					value.getBrandId().equals("1") &&
					value.getProductId().equals("35455") &&
					value.getPriceList() == 1
		);
	}

	@Test
	void test2() throws Exception {

		var request = PriceRequestDto.builder()
				.brandId(1)
				.dateTime(LocalDateTime.of(2020, 6, 14, 16, 0, 0))
				.productId("35455")
				.build();


		TestObserver<PriceResponseDto> response = controller.getPrice(request).test();
		response.await();
		response.assertNoErrors();
		response.assertComplete();
		response.assertValue(value ->
				value.getPrice().equals(new BigDecimal("25.45")) &&
						value.getBrandId().equals("1") &&
						value.getProductId().equals("35455") &&
						value.getPriceList() == 2
		);
	}

	@Test
	void test3() throws Exception {

		var request = PriceRequestDto.builder()
				.brandId(1)
				.dateTime(LocalDateTime.of(2020, 6, 14, 21, 0, 0))
				.productId("35455")
				.build();


		TestObserver<PriceResponseDto> response = controller.getPrice(request).test();
		response.await();
		response.assertNoErrors();
		response.assertComplete();
		response.assertValue(value ->
				value.getPrice().equals(new BigDecimal("35.50")) &&
						value.getBrandId().equals("1") &&
						value.getProductId().equals("35455") &&
						value.getPriceList() == 1
		);
	}

	@Test
	void test4() throws Exception {

		var request = PriceRequestDto.builder()
				.brandId(1)
				.dateTime(LocalDateTime.of(2020, 6, 15, 10, 0, 0))
				.productId("35455")
				.build();

		TestObserver<PriceResponseDto> response = controller.getPrice(request).test();
		response.await();
		response.assertNoErrors();
		response.assertComplete();
		response.assertValue(value ->
				value.getPrice().equals(new BigDecimal("30.50")) &&
						value.getBrandId().equals("1") &&
						value.getProductId().equals("35455") &&
						value.getPriceList() == 3
		);

	}

	@Test
	void test5() throws Exception {

		var request = PriceRequestDto.builder()
				.brandId(1)
				.dateTime(LocalDateTime.of(2020, 6, 16, 21, 0, 0))
				.productId("35455")
				.build();


		TestObserver<PriceResponseDto> response = controller.getPrice(request).test();
		response.await();
		response.assertNoErrors();
		response.assertComplete();
		response.assertValue(value ->
				value.getPrice().equals(new BigDecimal("38.95")) &&
						value.getBrandId().equals("1") &&
						value.getProductId().equals("35455") &&
						value.getPriceList() == 4
		);
	}


}
