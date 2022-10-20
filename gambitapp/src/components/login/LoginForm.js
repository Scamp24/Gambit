import "../../css/style.css"

const LoginForm = () => {
    return (
        <section class="section-book">
            <div class="row">
                <div class="book">
                    <div class="book__form">
                        <form action="#" class="form">


                            <div class="form__group">
                                <input type="text" class="form__input" placeholder="Full name" id="name" required />
                                <label for="name" class="form__label">Full name</label>
                            </div>

                            <div class="form__group">
                                <input type="email" class="form__input" placeholder="Email address" id="email" required />
                                <label for="email" class="form__label">Email address</label>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </section>
    )
}

export default LoginForm