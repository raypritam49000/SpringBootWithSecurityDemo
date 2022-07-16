package com.telemune.marketplace.rest.entity.vo;

public class PageVO {

	private Integer pageNumber;
	private Integer totalPages;
	private Long totalElements;
	private Integer size;

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * @return the totalElements
	 */
	public Long getTotalElements() {
		return totalElements;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageVO [pageNumber=" + pageNumber + ", totalPages=" + totalPages + ", totalElements=" + totalElements
				+ ", size=" + size + "]";
	}

}
