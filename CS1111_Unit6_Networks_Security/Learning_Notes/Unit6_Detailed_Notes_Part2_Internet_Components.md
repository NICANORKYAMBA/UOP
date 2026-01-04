# Unit 6 Learning Notes - Part 2: Internet Components

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 6 - Computer Networks and Security
- **Topic**: Internet Service Providers, WWW, DNS, IP Address, Web Browsers, Search Engines
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [How the Internet Works](#how-the-internet-works)
2. [Internet Service Providers (ISP)](#internet-service-providers-isp)
3. [World Wide Web (WWW)](#world-wide-web-www)
4. [Domain Name System (DNS)](#domain-name-system-dns)
5. [IP Addresses](#ip-addresses)
6. [Web Browsers](#web-browsers)
7. [Search Engines](#search-engines)

---

## How the Internet Works

### What is the Internet?

The **Internet** is a global network of interconnected computers and networks that communicate using standardized protocols (TCP/IP).

**Key Characteristics**:
- **Decentralized**: No single controlling authority
- **Global**: Spans all continents
- **Packet-Switched**: Data divided into packets
- **Protocol-Based**: TCP/IP standard

### Internet vs. World Wide Web

| Feature | Internet | World Wide Web |
|---------|----------|----------------|
| **Definition** | Global network infrastructure | Service running on internet |
| **Components** | Cables, routers, servers | Websites, HTML, HTTP |
| **Created** | 1960s (ARPANET) | 1989 (Tim Berners-Lee) |
| **Protocols** | TCP/IP | HTTP/HTTPS |
| **Scope** | Infrastructure | Application layer |

### How Data Travels on the Internet

**Step-by-Step Process**:

1. **Request Initiation**: User types URL in browser
2. **DNS Resolution**: Domain name converted to IP address
3. **Packet Creation**: Data divided into packets
4. **Routing**: Packets travel through multiple routers
5. **Reassembly**: Packets reassembled at destination
6. **Response**: Server sends requested data back

**Example**: Loading www.example.com

```
User Device → ISP Router → Internet Backbone → 
Destination ISP → Web Server → Response Back
```

### Internet Infrastructure

**Physical Components**:
- **Undersea Cables**: Connect continents (fiber optic)
- **Satellites**: Remote area connectivity
- **Data Centers**: House servers and storage
- **Internet Exchange Points (IXP)**: Where ISPs connect
- **Backbone Networks**: High-capacity connections

**Key Technologies**:
- **Fiber Optic Cables**: High-speed data transmission
- **Routers**: Direct traffic between networks
- **Servers**: Store and serve content
- **Protocols**: TCP/IP, HTTP, DNS, etc.

---

## Internet Service Providers (ISP)

### What is an ISP?

An **Internet Service Provider (ISP)** is a company that provides internet access to customers (individuals, businesses, organizations).

**Primary Function**: Connect users to the internet infrastructure

### Types of ISPs

#### 1. Tier 1 ISPs

**Definition**: Largest ISPs that own and operate global backbone networks.

**Characteristics**:
- Own international fiber optic cables
- Peer with other Tier 1 ISPs (no payment)
- Provide connectivity to Tier 2 ISPs
- Global reach

**Examples**:
- AT&T
- Verizon
- Level 3 Communications
- NTT Communications

#### 2. Tier 2 ISPs

**Definition**: Regional ISPs that purchase transit from Tier 1 ISPs.

**Characteristics**:
- Regional or national coverage
- Peer with some ISPs, pay Tier 1 for transit
- Provide connectivity to Tier 3 ISPs and end users

**Examples**:
- Regional telecom companies
- National ISPs in specific countries

#### 3. Tier 3 ISPs

**Definition**: Local ISPs that purchase internet access from Tier 2 ISPs.

**Characteristics**:
- Local coverage (city, region)
- Purchase all connectivity from upstream ISPs
- Serve end users directly

**Examples**:
- Local cable companies
- Small regional ISPs
- Municipal broadband providers

### ISP Connection Types

#### 1. Dial-Up (Legacy)

**Technology**: Modem over telephone line
**Speed**: Up to 56 Kbps
**Status**: Obsolete
**Pros**: Cheap, widely available
**Cons**: Very slow, ties up phone line

#### 2. DSL (Digital Subscriber Line)

**Technology**: Digital signals over telephone line
**Speed**: 1-100 Mbps
**Pros**: Always-on, doesn't tie up phone
**Cons**: Speed degrades with distance from exchange

**Types**:
- **ADSL**: Asymmetric (faster download than upload)
- **SDSL**: Symmetric (same speed both directions)

#### 3. Cable Internet

**Technology**: Coaxial cable (TV cable)
**Speed**: 10-1000 Mbps
**Pros**: Fast, widely available
**Cons**: Shared bandwidth (slower during peak times)

#### 4. Fiber Optic (FTTH/FTTP)

**Technology**: Fiber optic cables to home/premises
**Speed**: 100 Mbps - 10 Gbps
**Pros**: Fastest, most reliable, symmetric speeds
**Cons**: Limited availability, expensive installation

#### 5. Satellite

**Technology**: Communication satellites
**Speed**: 12-100 Mbps
**Pros**: Available in remote areas
**Cons**: High latency, weather-dependent, data caps

#### 6. Mobile/Cellular (4G/5G)

**Technology**: Cellular networks
**Speed**: 10-1000 Mbps (5G)
**Pros**: Portable, wireless
**Cons**: Data caps, coverage limitations

#### 7. Fixed Wireless

**Technology**: Radio signals from tower to antenna
**Speed**: 5-50 Mbps
**Pros**: No cables needed, good for rural areas
**Cons**: Line-of-sight required, weather-dependent

### ISP Connection Comparison

| Type | Speed | Latency | Availability | Cost | Best For |
|------|-------|---------|--------------|------|----------|
| **Dial-Up** | 56 Kbps | High | Universal | Very Low | Obsolete |
| **DSL** | 1-100 Mbps | Low | High | Low-Medium | Home/Small business |
| **Cable** | 10-1000 Mbps | Low | High | Medium | Home/Business |
| **Fiber** | 100 Mbps-10 Gbps | Very Low | Limited | High | Business/Power users |
| **Satellite** | 12-100 Mbps | Very High | Universal | High | Remote areas |
| **Mobile** | 10-1000 Mbps | Medium | High | Medium-High | Mobile users |

### ISP Services

**Core Services**:
- Internet connectivity
- IP address allocation
- DNS servers
- Email hosting

**Additional Services**:
- Web hosting
- Cloud storage
- VPN services
- Security (firewall, antivirus)
- Technical support

### ISP Security Risks

#### 1. Data Interception

**Risk**: ISP can monitor user traffic
**Mitigation**: Use VPN, HTTPS

#### 2. DNS Hijacking

**Risk**: ISP redirects DNS queries
**Mitigation**: Use third-party DNS (Google DNS, Cloudflare)

#### 3. Throttling

**Risk**: ISP slows specific traffic (streaming, torrents)
**Mitigation**: VPN, net neutrality regulations

---

## World Wide Web (WWW)

### What is the World Wide Web?

The **World Wide Web (WWW)** is an information system where documents and resources are identified by URLs and accessed via the internet using web browsers.

**Inventor**: Tim Berners-Lee (1989 at CERN)

### Key Components

#### 1. Web Pages

**Definition**: Documents written in HTML, displayed in browsers

**Types**:
- **Static**: Fixed content (HTML, CSS)
- **Dynamic**: Generated on-demand (PHP, JavaScript)

#### 2. Websites

**Definition**: Collection of related web pages under a domain

**Types**:
- **Informational**: News, blogs, wikis
- **E-commerce**: Online stores
- **Social Media**: Facebook, Twitter
- **Web Applications**: Gmail, Google Docs

#### 3. Hyperlinks

**Definition**: Clickable links connecting web pages

**Function**: Enable navigation between pages and sites

#### 4. URLs (Uniform Resource Locators)

**Structure**:
```
https://www.example.com:443/path/page.html?query=value#section

Protocol: https://
Subdomain: www
Domain: example.com
Port: 443 (default for HTTPS)
Path: /path/page.html
Query: ?query=value
Fragment: #section
```

### Web Technologies

**Core Technologies**:
- **HTML**: Structure and content
- **CSS**: Styling and layout
- **JavaScript**: Interactivity and behavior

**Server-Side**:
- **PHP, Python, Ruby**: Dynamic content generation
- **Databases**: MySQL, PostgreSQL, MongoDB

**Protocols**:
- **HTTP**: Hypertext Transfer Protocol
- **HTTPS**: Secure HTTP (encrypted with SSL/TLS)

### How the Web Works

**Request-Response Cycle**:

1. **User enters URL** in browser
2. **Browser resolves domain** to IP via DNS
3. **Browser sends HTTP request** to server
4. **Server processes request** and generates response
5. **Server sends HTTP response** (HTML, CSS, JS)
6. **Browser renders page** for user

**HTTP Request Example**:
```
GET /index.html HTTP/1.1
Host: www.example.com
User-Agent: Mozilla/5.0
Accept: text/html
```

**HTTP Response Example**:
```
HTTP/1.1 200 OK
Content-Type: text/html
Content-Length: 1234

<html>...</html>
```

### Web vs. Internet

**The Web is ONE service on the Internet**

Other internet services:
- Email (SMTP, IMAP, POP3)
- File Transfer (FTP)
- Remote Access (SSH, Telnet)
- Instant Messaging
- VoIP (Voice over IP)
- Streaming (RTSP)

---

## Domain Name System (DNS)

### What is DNS?

The **Domain Name System (DNS)** is the internet's phonebook, translating human-readable domain names into IP addresses.

**Function**: Convert www.example.com → 93.184.216.34

### Why DNS is Needed

**Problem**: Computers use IP addresses (93.184.216.34), humans prefer names (www.example.com)

**Solution**: DNS translates names to addresses automatically

### Domain Name Structure

**Hierarchical Structure** (right to left):

```
www.example.com.
 |     |      |  |
Sub  Second  Top Root
domain Level Level
      Domain Domain
```

**Components**:
1. **Root Domain**: . (dot) - implicit
2. **Top-Level Domain (TLD)**: .com, .org, .net, .edu, .uk
3. **Second-Level Domain**: example (registered by owner)
4. **Subdomain**: www, mail, blog (optional)

### Types of Top-Level Domains (TLDs)

#### 1. Generic TLDs (gTLDs)

- **.com**: Commercial (most popular)
- **.org**: Organizations (non-profit)
- **.net**: Network infrastructure
- **.edu**: Educational institutions (US)
- **.gov**: US government
- **.mil**: US military
- **.info**: Information sites
- **.biz**: Business

#### 2. Country Code TLDs (ccTLDs)

- **.us**: United States
- **.uk**: United Kingdom
- **.ca**: Canada
- **.de**: Germany
- **.jp**: Japan
- **.cn**: China
- **.au**: Australia

#### 3. New gTLDs

- **.app**: Applications
- **.blog**: Blogs
- **.shop**: E-commerce
- **.tech**: Technology
- **.ai**: Artificial Intelligence

### How DNS Works

**DNS Resolution Process**:

1. **User types URL**: www.example.com
2. **Browser checks cache**: Local DNS cache
3. **Query to Recursive Resolver**: ISP's DNS server
4. **Query to Root Server**: Returns TLD server address
5. **Query to TLD Server**: Returns authoritative server
6. **Query to Authoritative Server**: Returns IP address
7. **IP returned to browser**: Browser connects to server

**DNS Query Flow**:
```
Browser → Recursive Resolver → Root Server → 
TLD Server → Authoritative Server → IP Address
```

### DNS Record Types

#### 1. A Record (Address)

**Purpose**: Maps domain to IPv4 address
**Example**: example.com → 93.184.216.34

#### 2. AAAA Record

**Purpose**: Maps domain to IPv6 address
**Example**: example.com → 2606:2800:220:1:248:1893:25c8:1946

#### 3. CNAME Record (Canonical Name)

**Purpose**: Alias one domain to another
**Example**: www.example.com → example.com

#### 4. MX Record (Mail Exchange)

**Purpose**: Specifies mail servers for domain
**Example**: example.com → mail.example.com

#### 5. TXT Record

**Purpose**: Store text information (SPF, DKIM, verification)
**Example**: Domain ownership verification

#### 6. NS Record (Name Server)

**Purpose**: Specifies authoritative DNS servers
**Example**: example.com → ns1.example.com

### DNS Caching

**Purpose**: Speed up DNS resolution, reduce load

**Cache Levels**:
1. **Browser Cache**: Stores recent lookups
2. **Operating System Cache**: System-level cache
3. **Router Cache**: Local network cache
4. **ISP Cache**: Recursive resolver cache

**TTL (Time To Live)**: How long to cache (seconds)

### DNS Security

#### DNS Spoofing/Cache Poisoning

**Attack**: Inject false DNS records
**Impact**: Redirect users to malicious sites
**Mitigation**: DNSSEC (DNS Security Extensions)

#### DNS Hijacking

**Attack**: Redirect DNS queries to malicious servers
**Impact**: Intercept traffic, phishing
**Mitigation**: Use trusted DNS servers

**Secure DNS Providers**:
- **Google Public DNS**: 8.8.8.8, 8.8.4.4
- **Cloudflare DNS**: 1.1.1.1, 1.0.0.1
- **Quad9**: 9.9.9.9

---

## IP Addresses

### What is an IP Address?

An **IP Address (Internet Protocol Address)** is a unique numerical identifier assigned to each device on a network.

**Function**: Identify and locate devices on networks

**Analogy**: Like a postal address for computers

### IPv4 (Internet Protocol version 4)

**Format**: Four octets separated by dots (dotted decimal)
**Example**: 192.168.1.1
**Size**: 32 bits (4 bytes)
**Range**: 0.0.0.0 to 255.255.255.255
**Total Addresses**: ~4.3 billion (2³²)

**Structure**:
```
192  .  168  .  1  .  1
8 bits  8 bits  8 bits  8 bits = 32 bits total
```

**Binary Representation**:
```
192.168.1.1
11000000.10101000.00000001.00000001
```

### IPv4 Address Classes

#### Class A

**Range**: 1.0.0.0 to 126.255.255.255
**Default Mask**: 255.0.0.0 (/8)
**Networks**: 126
**Hosts per Network**: 16,777,214
**Use**: Large organizations

#### Class B

**Range**: 128.0.0.0 to 191.255.255.255
**Default Mask**: 255.255.0.0 (/16)
**Networks**: 16,384
**Hosts per Network**: 65,534
**Use**: Medium organizations

#### Class C

**Range**: 192.0.0.0 to 223.255.255.255
**Default Mask**: 255.255.255.0 (/24)
**Networks**: 2,097,152
**Hosts per Network**: 254
**Use**: Small networks

#### Class D (Multicast)

**Range**: 224.0.0.0 to 239.255.255.255
**Use**: Multicast groups

#### Class E (Reserved)

**Range**: 240.0.0.0 to 255.255.255.255
**Use**: Experimental

### Private IP Addresses

**Purpose**: Used within private networks (not routable on internet)

**Ranges**:
- **Class A**: 10.0.0.0 to 10.255.255.255
- **Class B**: 172.16.0.0 to 172.31.255.255
- **Class C**: 192.168.0.0 to 192.168.255.255

**Use Cases**:
- Home networks
- Office LANs
- Internal corporate networks

### Public IP Addresses

**Purpose**: Globally unique, routable on internet

**Assignment**: Allocated by ISPs from regional registries

**Use Cases**:
- Web servers
- Email servers
- Public-facing services

### Special IP Addresses

- **127.0.0.1**: Localhost (loopback)
- **0.0.0.0**: Default route, unspecified
- **255.255.255.255**: Broadcast address
- **169.254.x.x**: APIPA (Automatic Private IP Addressing)

### IPv6 (Internet Protocol version 6)

**Reason for IPv6**: IPv4 address exhaustion

**Format**: Eight groups of four hexadecimal digits
**Example**: 2001:0db8:85a3:0000:0000:8a2e:0370:7334
**Size**: 128 bits (16 bytes)
**Total Addresses**: 340 undecillion (2¹²⁸)

**Shortened Format**:
```
Full: 2001:0db8:0000:0000:0000:0000:0000:0001
Shortened: 2001:db8::1
```

**Rules**:
- Leading zeros can be omitted
- Consecutive zero groups replaced with ::

### IPv4 vs. IPv6

| Feature | IPv4 | IPv6 |
|---------|------|------|
| **Address Size** | 32 bits | 128 bits |
| **Format** | Dotted decimal | Hexadecimal |
| **Total Addresses** | 4.3 billion | 340 undecillion |
| **Example** | 192.168.1.1 | 2001:db8::1 |
| **Header Size** | Variable | Fixed (40 bytes) |
| **Security** | Optional (IPsec) | Built-in (IPsec) |
| **Status** | Widely used | Growing adoption |

### Static vs. Dynamic IP

#### Static IP

**Definition**: Permanently assigned IP address
**Pros**: Consistent, good for servers
**Cons**: More expensive, manual configuration
**Use**: Web servers, email servers, VPN

#### Dynamic IP

**Definition**: Temporarily assigned IP (DHCP)
**Pros**: Automatic, cost-effective
**Cons**: Changes periodically
**Use**: Home users, mobile devices

### NAT (Network Address Translation)

**Purpose**: Allow multiple devices to share one public IP

**How it Works**:
1. Private IPs used internally (192.168.x.x)
2. Router translates to public IP for internet
3. Router tracks connections and routes responses back

**Benefits**:
- Conserves public IP addresses
- Adds security layer
- Enables home networks

---

## Web Browsers

### What is a Web Browser?

A **web browser** is software that retrieves, presents, and navigates information on the World Wide Web.

**Function**: Interpret and display HTML, CSS, JavaScript

### Popular Web Browsers

1. **Google Chrome** (65% market share)
2. **Safari** (19% - Apple devices)
3. **Microsoft Edge** (5%)
4. **Firefox** (3%)
5. **Opera** (2%)

### Browser Components

#### 1. User Interface

- Address bar (URL input)
- Back/Forward buttons
- Bookmarks
- Tabs
- Settings

#### 2. Browser Engine

- Coordinates between UI and rendering engine

#### 3. Rendering Engine

**Purpose**: Parse HTML/CSS and display content

**Popular Engines**:
- **Blink**: Chrome, Edge, Opera
- **WebKit**: Safari
- **Gecko**: Firefox

#### 4. JavaScript Engine

**Purpose**: Execute JavaScript code

**Popular Engines**:
- **V8**: Chrome, Edge, Node.js
- **SpiderMonkey**: Firefox
- **JavaScriptCore**: Safari

#### 5. Networking

- Handle HTTP/HTTPS requests
- Manage cookies
- Cache resources

#### 6. Data Storage

- **Cookies**: Small text files
- **Local Storage**: Key-value pairs (persistent)
- **Session Storage**: Temporary storage
- **IndexedDB**: Client-side database

### How Browsers Work

**Page Loading Process**:

1. **Parse HTML**: Build DOM (Document Object Model) tree
2. **Parse CSS**: Build CSSOM (CSS Object Model) tree
3. **Combine**: Create Render Tree
4. **Layout**: Calculate positions and sizes
5. **Paint**: Draw pixels on screen
6. **Execute JavaScript**: Add interactivity

**Critical Rendering Path**:
```
HTML → DOM Tree
CSS → CSSOM Tree
DOM + CSSOM → Render Tree → Layout → Paint
```

### Browser Features

**Core Features**:
- Tabbed browsing
- Bookmarks/Favorites
- History
- Downloads manager
- Extensions/Add-ons
- Developer tools

**Security Features**:
- HTTPS encryption
- Pop-up blocker
- Phishing protection
- Sandboxing
- Private/Incognito mode

**Privacy Features**:
- Cookie management
- Do Not Track
- Private browsing
- Password manager
- Ad blockers (extensions)

### Browser Security

#### HTTPS (SSL/TLS)

**Purpose**: Encrypt communication between browser and server
**Indicator**: Padlock icon in address bar
**Importance**: Protects sensitive data (passwords, credit cards)

#### Same-Origin Policy

**Purpose**: Prevent malicious scripts from accessing data from other sites
**Rule**: Scripts can only access data from same origin (protocol + domain + port)

#### Content Security Policy (CSP)

**Purpose**: Prevent XSS (Cross-Site Scripting) attacks
**Method**: Whitelist trusted content sources

---

## Search Engines

### What is a Search Engine?

A **search engine** is a software system that searches the web for information based on user queries and returns relevant results.

**Function**: Index web content and provide search functionality

### Popular Search Engines

1. **Google** (92% market share)
2. **Bing** (3%)
3. **Yahoo** (1%)
4. **Baidu** (China)
5. **Yandex** (Russia)
6. **DuckDuckGo** (privacy-focused)

### How Search Engines Work

#### 1. Crawling

**Process**: Automated bots (spiders/crawlers) discover and visit web pages

**Googlebot**: Google's web crawler
**Method**: Follow links from page to page

#### 2. Indexing

**Process**: Analyze and store page content in massive databases

**Indexed Data**:
- Page content (text, images, videos)
- Keywords
- Page structure
- Links
- Metadata

#### 3. Ranking

**Process**: Determine relevance and order of search results

**Ranking Factors** (Google uses 200+):
- **Relevance**: Keyword matching
- **Authority**: Backlinks, domain authority
- **User Experience**: Page speed, mobile-friendliness
- **Content Quality**: Originality, depth, freshness
- **User Engagement**: Click-through rate, bounce rate

#### 4. Serving Results

**Process**: Display ranked results to user

**SERP (Search Engine Results Page)**:
- Organic results
- Paid ads (sponsored)
- Featured snippets
- Knowledge panels
- Images, videos, news

### Search Query Types

#### 1. Navigational

**Intent**: Find specific website
**Example**: "facebook login", "amazon"

#### 2. Informational

**Intent**: Learn about topic
**Example**: "how does DNS work", "what is IP address"

#### 3. Transactional

**Intent**: Complete action (buy, download)
**Example**: "buy laptop online", "download chrome"

### Search Operators

**Advanced Search Techniques**:

- **"exact phrase"**: Search exact phrase
- **site:example.com**: Search within specific site
- **filetype:pdf**: Search specific file types
- **-exclude**: Exclude term from results
- **OR**: Search for either term
- **intitle:**: Search in page title
- **inurl:**: Search in URL

**Example**: `site:wikipedia.org "computer networks" filetype:pdf`

### SEO (Search Engine Optimization)

**Purpose**: Improve website visibility in search results

**On-Page SEO**:
- Quality content
- Keywords in title, headings, content
- Meta descriptions
- Image alt text
- Internal linking
- Page speed

**Off-Page SEO**:
- Backlinks from authoritative sites
- Social media presence
- Brand mentions

**Technical SEO**:
- Mobile-friendly design
- HTTPS encryption
- XML sitemap
- Structured data (Schema.org)

### Search Engine Privacy

**Privacy Concerns**:
- Search history tracking
- Personalized results (filter bubble)
- Data collection for advertising

**Privacy-Focused Alternatives**:
- **DuckDuckGo**: No tracking, no personalization
- **Startpage**: Google results without tracking
- **Brave Search**: Independent index, privacy-first

---

## Key Takeaways

1. **ISPs** provide internet connectivity using various technologies (DSL, cable, fiber, satellite)
2. **WWW** is a service on the internet using HTTP/HTTPS protocols
3. **DNS** translates domain names to IP addresses (internet's phonebook)
4. **IP addresses** uniquely identify devices (IPv4: 32-bit, IPv6: 128-bit)
5. **Web browsers** render HTML/CSS/JavaScript and provide web access
6. **Search engines** crawl, index, rank, and serve web content

---

## Study Tips

1. **Understand relationships**: Internet → ISP → WWW → DNS → IP → Browser → Search
2. **Memorize key concepts**: DNS resolution process, IPv4 vs IPv6, browser rendering
3. **Practice scenarios**: How does typing a URL result in a displayed page?
4. **Know security risks**: ISP monitoring, DNS hijacking, browser vulnerabilities
5. **Compare technologies**: Different ISP types, browser engines, search engines

---

## References

Cloudflare. (n.d.). *What is DNS? | How DNS works*. https://www.cloudflare.com/learning/dns/what-is-dns/

Cloudflare. (n.d.). *What is my IP address? | IP address definition*. https://www.cloudflare.com/learning/dns/glossary/what-is-my-ip-address/

Davis, A. (2021, March 10). *How the Internet works in 5 minutes* [Video]. YouTube.

MDN Web Docs. (n.d.). *How does the Internet work?* https://developer.mozilla.org/en-US/docs/Learn_web_development/Howto/Web_mechanics/How_does_the_Internet_work

MDN Web Docs. (n.d.). *How browsers work*. https://developer.mozilla.org/en-US/docs/Web/Performance/Guides/How_browsers_work

---

**Next**: Part 3 - Computer Security (CIA Triad, Threats, Attacks, Viruses, Trojans, Firewalls)
