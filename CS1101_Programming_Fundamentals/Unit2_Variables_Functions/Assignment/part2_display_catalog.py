def display_catalog():
    """
    Display product catalog with pricing for individual items,
    combo packs, and gift packs with appropriate discounts.
    
    Pricing Rules:
    - Individual items: No discount
    - Combo pack (2 items): 10% discount
    - Gift pack (3 items): 25% discount
    """
    # Product prices
    item1_name = "Laptop"
    item1_price = 1200.00
    
    item2_name = "Mouse"
    item2_price = 25.00
    
    item3_name = "Keyboard"
    item3_price = 75.00
    
    # Calculate combo and gift pack prices
    combo1_price = (item1_price + item2_price) * 0.90  # 10% discount
    combo2_price = (item1_price + item3_price) * 0.90  # 10% discount
    combo3_price = (item2_price + item3_price) * 0.90  # 10% discount
    
    gift_pack_price = (item1_price + item2_price + item3_price) * 0.75  # 25% discount
    
    # Display catalog
    print("=" * 60)
    print("TECHSTORE PRODUCT CATALOG".center(60))
    print("=" * 60)
    print("For delivery Contact: +1-555-TECH-SHOP")
    print()
    
    # Individual items
    print("INDIVIDUAL ITEMS (No Discount)")
    print("-" * 60)
    print(f"Product 1: {item1_name:<20} ${item1_price:>10.2f}")
    print(f"Product 2: {item2_name:<20} ${item2_price:>10.2f}")
    print(f"Product 3: {item3_name:<20} ${item3_price:>10.2f}")
    print()
    
    # Combo packs
    print("COMBO PACKS (10% Discount)")
    print("-" * 60)
    print(f"Combo 1: {item1_name} + {item2_name:<12} ${combo1_price:>10.2f}")
    print(f"         (Regular: ${item1_price + item2_price:.2f}, You Save: ${(item1_price + item2_price) * 0.10:.2f})")
    print()
    print(f"Combo 2: {item1_name} + {item3_name:<12} ${combo2_price:>10.2f}")
    print(f"         (Regular: ${item1_price + item3_price:.2f}, You Save: ${(item1_price + item3_price) * 0.10:.2f})")
    print()
    print(f"Combo 3: {item2_name} + {item3_name:<12} ${combo3_price:>10.2f}")
    print(f"         (Regular: ${item2_price + item3_price:.2f}, You Save: ${(item2_price + item3_price) * 0.10:.2f})")
    print()
    
    # Gift pack
    print("GIFT PACK (25% Discount - Best Value!)")
    print("-" * 60)
    total_regular = item1_price + item2_price + item3_price
    savings = total_regular * 0.25
    print(f"Gift Pack: All 3 Items{' ' * 15} ${gift_pack_price:>10.2f}")
    print(f"           (Regular: ${total_regular:.2f}, You Save: ${savings:.2f})")
    print()
    print("=" * 60)

# Run the catalog display
display_catalog()
